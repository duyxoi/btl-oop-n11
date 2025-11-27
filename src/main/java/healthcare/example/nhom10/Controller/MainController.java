package healthcare.example.nhom10.Controller;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import healthcare.example.nhom10.Entity.BenhNhan;
import healthcare.example.nhom10.Entity.HoSoBeNhan;
import healthcare.example.nhom10.Entity.Nguoi;
import healthcare.example.nhom10.service.BenhNhanService;
import healthcare.example.nhom10.service.HoSoBeNhanService;
import healthcare.example.nhom10.service.NguoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private NguoiService nguoiService;

    @Autowired
    private BenhNhanService  benhNhanService;

    @Autowired
    private HoSoBeNhanService hoSoBeNhanService;

    // ⛔️ THÊM PHƯƠNG THỨC LANDING PAGE ⛔️
    @GetMapping({"/", "/index"})
    public String landingPage() {
        return "landing"; // Trả về tệp HTML có tên là landing.html
    }
    // ------------------------------------
    @GetMapping("/login")
    public String login() {
        // Thay vì trả về view login, ta chuyển hướng về trang chủ
        // nơi JavaScript sẽ kiểm tra tham số URL và hiển thị Modal Login.
        return "redirect:/";
    }

    // 1. Hiển thị form đăng ký (GET)
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        BenhNhan benhNhan = new BenhNhan();
        // Bắt buộc phải tạo Nguoi để Thymeleaf trên register.html không bị lỗi Null
        benhNhan.setNguoi(new Nguoi());
        model.addAttribute("benhNhan", benhNhan);

        // 💡 TRẢ VỀ VIEW "register"
        return "register";
    }

    // 2. Xử lý POST Đăng ký
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("benhNhan") BenhNhan benhNhan, RedirectAttributes redirectAttributes) {

        Nguoi nguoi = benhNhan.getNguoi();

        // ⛔️ FIX LỖI NULL POINTER VÀ KIỂM TRA ĐẦU VÀO ⛔️
        if (nguoi == null || nguoi.getUsername() == null || nguoi.getUsername().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Tên đăng nhập không được để trống.");
            return "redirect:/register";
        }

        // Kiểm tra trùng username
        if (nguoiService.existsByUsername(nguoi.getUsername())) {
            redirectAttributes.addFlashAttribute("error", "Tên đăng nhập đã tồn tại. Vui lòng chọn tên khác.");
            return "redirect:/register"; // Quay lại trang đăng ký nếu lỗi
        }

        String matKhauTho = nguoi.getPassword();
        nguoi.setPassword("{noop}" + matKhauTho);

        nguoi.setRole("ROLE_PATIENT");
        nguoi.setEnabled(true);

        try {
            benhNhanService.createBenhNhan(benhNhan);
            HoSoBeNhan hoSoBeNhan = new HoSoBeNhan();
            hoSoBeNhan.setBenhNhan(benhNhan);
            hoSoBeNhanService.createHoSoBeNhan(hoSoBeNhan);

            // ✅ THÀNH CÔNG: Chuyển hướng về trang chủ và mở Modal Login
            return "redirect:/?registerSuccess=true";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi hệ thống khi đăng ký. Vui lòng thử lại.");
            return "redirect:/register"; // Quay lại trang đăng ký nếu lỗi
        }
    }
}