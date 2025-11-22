package healthcare.example.nhom10.Controller;

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

    @GetMapping("/login")
    public String login() {
        return "login"; // trả về trang login.html
    }


    // 1. Hiển thị form đăng ký (GET)
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        BenhNhan benhNhan = new BenhNhan();

        // QUAN TRỌNG: Phải tạo mới đối tượng Nguoi bên trong BenhNhan
        // Nếu không, view sẽ không thể trỏ tới *{nguoi.hoTen}...
        benhNhan.setNguoi(new Nguoi());

        model.addAttribute("benhNhan", benhNhan);
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("benhNhan") BenhNhan benhNhan, Model model) {

        // Lấy đối tượng Nguoi từ BenhNhan ra để xử lý
        Nguoi nguoi = benhNhan.getNguoi();

        // Kiểm tra trùng username
        if (nguoiService.existsByUsername(nguoi.getUsername())) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại!");
            return "register";
        }

        String matKhauTho = nguoi.getPassword();
        nguoi.setPassword("{noop}" + matKhauTho);

        // Thiết lập các giá trị mặc định
        nguoi.setRole("ROLE_PATIENT");  // Mặc định là Bệnh nhân
        nguoi.setEnabled(true);    // Kích hoạt tài khoản

        // Lưu vào DB
        // Do CascadeType.ALL, chỉ cần lưu BenhNhan, Nguoi sẽ tự được lưu
        benhNhanService.createBenhNhan(benhNhan);

        HoSoBeNhan hoSoBeNhan = new HoSoBeNhan();
        hoSoBeNhan.setBenhNhan(benhNhan);
        hoSoBeNhanService.createHoSoBeNhan(hoSoBeNhan);

        return "redirect:/login?registerSuccess";
    }

}
