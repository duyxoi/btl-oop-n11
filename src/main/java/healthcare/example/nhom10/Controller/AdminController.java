package healthcare.example.nhom10.Controller;

import healthcare.example.nhom10.Entity.*;
import healthcare.example.nhom10.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
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

    @Autowired
    public AdminController(BacSiService bacSiService, BenhNhanService benhNhanService, DichVuYTeService dichVuYTeService, DonThuocService donThuocService, HoSoBeNhanService hoSoBeNhanService, KeDonService keDonService, KhoaService khoaService, LichSuKhamService lichSuKhamService, LoaiThuocService loaiThuocService, NguoiService nguoiService, PhieuDichVuService phieuDichVuService) {
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
    }

    @GetMapping("/list/benhnhan")
    public String listBenhnhan(
            @RequestParam(required = false) String cccd,
            @RequestParam(required = false) String sort,
            Model model) {

        List<BenhNhan> dsBenhNhan;

        // 🔹 1. Tìm kiếm theo CCCD
        if (cccd != null && !cccd.isEmpty()) {
            dsBenhNhan = benhNhanService.findByCccd(cccd);

            // 🔹 2. Sắp xếp theo tên
        } else if ("ten".equals(sort)) {
            dsBenhNhan = benhNhanService.sortByHoTen();

            // 🔹 3. Sắp xếp theo ngày sinh
        } else if ("ngaySinh".equals(sort)) {
            dsBenhNhan = benhNhanService.sortByNgaySinh();

            // 🔹 4. Mặc định: hiển thị toàn bộ
        } else if ("maBenhNhan".equals(sort)) {
            dsBenhNhan =  benhNhanService.sortByMaBenhNhan();
        }
        else {
            dsBenhNhan = benhNhanService.getAllBenhNhan();
        }

        model.addAttribute("dsBenhNhan", dsBenhNhan);
        model.addAttribute("cccd", cccd); // để hiển thị lại giá trị trong ô tìm kiếm

        return "admin/benhnhan_list";
    }

    @GetMapping("/")
    public String home() {
        return "admin/home";
    }

    @GetMapping("/list/bacsi")
    public String listBacsi(Model model) {
        List<BacSi> ds = bacSiService.getAllBacSi();
        model.addAttribute("dsBacSi", ds);
        return "admin/bacsi_list";
    }

    @GetMapping("/hosobenhnhan/{id}")
    public String hoso(Model model, @PathVariable int id){
        HoSoBeNhan x = hoSoBeNhanService.getHoSoBeNhanById(id).get();
        model.addAttribute("hoSoBeNhan", x);
        return "admin/hoso";
    }


    // 🏥 KHOA
    @GetMapping("/list/khoa")
    public String listKhoa(Model model) {
        model.addAttribute("dsKhoa", khoaService.getAllKhoa());
        model.addAttribute("khoa", new Khoa());
        return "admin/khoa_list";
    }

    @PostMapping("/list/khoa/add")
    public String addKhoa(@ModelAttribute Khoa khoa) {
        khoaService.createKhoa(khoa);
        return "redirect:/admin/list/khoa";
    }

    // 💊 LOẠI THUỐC
    @GetMapping("/list/loaithuoc")
    public String listLoaiThuoc(Model model) {
        model.addAttribute("dsThuoc", loaiThuocService.getAllLoaiThuoc());
        model.addAttribute("thuoc", new LoaiThuoc());
        return "admin/loaithuoc_list";
    }

    @PostMapping("/list/loaithuoc/add")
    public String addLoaiThuoc(@ModelAttribute LoaiThuoc lt) {
        loaiThuocService.createLoaiThuoc(lt);
        return "redirect:/admin/list/loaithuoc";
    }

    // 🧾 DỊCH VỤ Y TẾ
    @GetMapping("/list/dichvu")
    public String listDichVu(Model model) {
        model.addAttribute("dsDichVu", dichVuYTeService.getAllDichVuYTe());
        model.addAttribute("dichvu", new DichVuYTe());
        return "admin/dichvu_list";
    }

    @PostMapping("/list/dichvu/add")
    public String addDichVu(@ModelAttribute DichVuYTe dv) {
        dichVuYTeService.createDichVuYTe(dv);
        return "redirect:/admin/list/dichvu";
    }

    @GetMapping("/thongke")
    public String thongKe(Model model) {
        model.addAttribute("lichSuKham",lichSuKhamService.getAllLichSuKham());
        return "admin/thongke";
    }



}
