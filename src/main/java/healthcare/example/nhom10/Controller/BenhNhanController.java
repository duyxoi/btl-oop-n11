package healthcare.example.nhom10.Controller;

import healthcare.example.nhom10.Entity.*;
import healthcare.example.nhom10.common.CustomUserDetails;
import healthcare.example.nhom10.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/benhnhan")
public class BenhNhanController {
    private final BacSiService bacSiService;
    private final BenhNhanService benhNhanService;
    private final DichVuYTeService dichVuYTeService;
    private final DonThuocService donThuocService;
    private final HoSoBeNhanService hoSoBeNhanService;
    private final KeDonService keDonService;
    private final KhoaService khoaService;
    private final LichSuKhamService lichSuKhamService;
    private final LoaiThuocService loaiThuocService;
    private final NguoiService nguoiService;
    private final PhieuDichVuService phieuDichVuService;
    private final DatLichKhamService datLichKhamService;

    @Autowired
    public BenhNhanController(BacSiService bacSiService, BenhNhanService benhNhanService, DichVuYTeService dichVuYTeService, DonThuocService donThuocService, HoSoBeNhanService hoSoBeNhanService, KeDonService keDonService, KhoaService khoaService, LichSuKhamService lichSuKhamService, LoaiThuocService loaiThuocService, NguoiService nguoiService, PhieuDichVuService phieuDichVuService, DatLichKhamService datLichKhamService) {
        this.bacSiService = bacSiService;
        this.benhNhanService = benhNhanService;
        this.dichVuYTeService = dichVuYTeService;
        this.donThuocService = donThuocService;
        this.hoSoBeNhanService = hoSoBeNhanService;
        this.keDonService = keDonService;
        this.khoaService = khoaService;
        this.lichSuKhamService = lichSuKhamService;
        this.loaiThuocService = loaiThuocService;
        this.nguoiService = nguoiService;
        this.phieuDichVuService = phieuDichVuService;
        this.datLichKhamService = datLichKhamService;
    }

        @GetMapping("/")
        public String home(Model model){
            CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            int personId = userDetails.getPersonId();
            Nguoi nguoi = userDetails.getNguoi();

            model.addAttribute("personId", personId);


            return "benhnhan/home";
        }

    @GetMapping("/hoso/{id}")
    public String xemHoSo(@PathVariable int id, Model model){
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        int personId = userDetails.getPersonId();
        Nguoi nguoi = userDetails.getNguoi();
        System.out.println(nguoi);

        BenhNhan bn = benhNhanService.getBenhNhanByNguoi(nguoi)
                .orElseThrow(()-> new RuntimeException("Benh nhan id "+ id+" not found"));


        HoSoBeNhan hoSo = hoSoBeNhanService.getHoSoBeNhanByBenhNhan(bn)
                .orElseThrow(() -> new RuntimeException("HoSoBeNhan id " + id + " not found"));

//        if(nguoi.getRole().equals("ROLE_PATIENT") && hoSo.getBenhNhan().getNguoi().getPersonId() != personId){
//            return "error/403";
//        }

        model.addAttribute("nguoi", nguoi);
        model.addAttribute("hoSo", hoSo);
        return "benhnhan/hoso";
    }

    @GetMapping("/dat-lich")
    public String hienThiFormDatLich(Model model) {
        // Lấy thông tin user hiện tại
        CustomUserDetails userDetails =
                (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Nguoi nguoi = userDetails.getNguoi();

        // Lấy thông tin bệnh nhân tương ứng
        BenhNhan benhNhan = benhNhanService.getBenhNhanByNguoi(nguoi)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bệnh nhân tương ứng với người đăng nhập."));

        // Lấy danh sách bác sĩ và dịch vụ y tế để hiển thị dropdown
        List<BacSi> bacSiList = bacSiService.getAllBacSi();
        List<DichVuYTe> dichVuList = dichVuYTeService.getAllDichVuYTe();

        model.addAttribute("lichKham", new DatLichKham());
        model.addAttribute("benhNhan", benhNhan);
        model.addAttribute("bacSiList", bacSiList);
        model.addAttribute("khoaList", khoaService.getAllKhoa());


        return "benhnhan/dat_lich"; // -> templates/benhnhan/dat_lich.html
    }


    // ------------------- LẤY DANH SÁCH BÁC SĨ THEO KHOA (AJAX) -------------------
    @GetMapping("/bacsi-by-khoa/{maKhoa}")
    @ResponseBody
    public List<BacSi> getBacSiByKhoa(@PathVariable("maKhoa") int maKhoa) {
        return khoaService.getKhoaById(maKhoa).get().getBacSi();
    }

    /**
     * Xử lý khi bệnh nhân gửi form đặt lịch
     */
    @PostMapping("/dat-lich")
    public String datLich(
            @RequestParam("maBenhNhan") int maBenhNhan,
            @RequestParam("maBacSi") int maBacSi,
            @RequestParam("maKhoa") int maKhoa,
            @RequestParam("ngayKham") String ngayKhamStr,
            @RequestParam("gioBatDau") String gioBatDau,
            @RequestParam("gioKetThuc") String gioKetThuc,
            RedirectAttributes redirectAttributes
    ) {
        try {
            // --- 1️⃣ Lấy người đăng nhập ---
            CustomUserDetails userDetails =
                    (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Nguoi nguoi = userDetails.getNguoi();

            // --- 2️⃣ Lấy thông tin bệnh nhân tương ứng ---
            BenhNhan benhNhan = benhNhanService.getBenhNhanByNguoi(nguoi)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy bệnh nhân."));

            Khoa khoa = khoaService.getKhoaById(maKhoa)
                    .orElseThrow(() -> new RuntimeException("Khong tim thay khoa tuong ung"));

            // --- 3️⃣ Lấy thông tin bác sĩ & dịch vụ ---
            BacSi bacSi = bacSiService.getBacSiById(maBacSi)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy bác sĩ."));

            // --- 4️⃣ Ghép ngày và giờ khám ---
            String dateTimeString = ngayKhamStr + " " + gioBatDau + ":00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Timestamp ngayKham = new Timestamp(sdf.parse(dateTimeString).getTime());

            // 5️⃣ Kiểm tra trùng lịch trước khi lưu
            boolean trungLich = datLichKhamService.existsByBacSiAndNgayKham(
                    bacSi, ngayKham.toLocalDateTime()
            );

            if (trungLich) {
                redirectAttributes.addFlashAttribute("errorMessage",
                        "❌ Bác sĩ này đã có lịch khám trong khung giờ " + gioBatDau + " - " + gioKetThuc + "!");
                return "redirect:/benhnhan/dat-lich";
            }


            // --- 5️⃣ Tạo đối tượng lịch khám ---
            DatLichKham lich = new DatLichKham();
            lich.setBenhNhan(benhNhan);
            lich.setBacSi(bacSi);
            lich.setNgayKham(ngayKham.toLocalDateTime());
            lich.setKhoa(khoa);
            lich.setNgayTaoLich(new Date());
            lich.setTrangThai("DA_XAC_NHAN");

            datLichKhamService.save(lich);

            // --- 6️⃣ Gửi thông báo flash ---
            redirectAttributes.addFlashAttribute("successMessage", "✅ Đặt lịch khám thành công!");

            // --- 7️⃣ Quay về trang home ---
            return "redirect:/benhnhan/lich-kham";

        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage", "❌ Lỗi khi đặt lịch: " + e.getMessage());
            return "redirect:/benhnhan/dat-lich";
        }
    }

    @GetMapping("/lich-kham")
    public String xemLichKham(Model model) {
        // Lấy thông tin user hiện tại
        CustomUserDetails userDetails =
                (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Nguoi nguoi = userDetails.getNguoi();

        // Lấy bệnh nhân tương ứng
        BenhNhan benhNhan = benhNhanService.getBenhNhanByNguoi(nguoi)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bệnh nhân."));

        // Lấy danh sách lịch khám của bệnh nhân
        List<DatLichKham> lichKhams = datLichKhamService.getByBenhNhan(benhNhan);

        model.addAttribute("lichKhams", lichKhams);
        return "benhnhan/lich_kham"; // Giao diện hiển thị danh sách lịch khám
    }

    @PostMapping("/huy-lich/{id}")
    public String xoaLichKham(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try {
            datLichKhamService.delete(id);
            redirectAttributes.addFlashAttribute("successMessage", "🗑️ Đã xóa lịch khám thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "❌ Không thể xóa lịch khám: " + e.getMessage());
        }
        return "redirect:/benhnhan/lich-kham";
    }




}
