package healthcare.example.nhom10.Controller;

import healthcare.example.nhom10.common.CustomUserDetails;
import healthcare.example.nhom10.Entity.*;
import healthcare.example.nhom10.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bacsi")
public class BacSiController {

    @Autowired
    private BenhNhanService benhNhanService;

    @Autowired
    private BacSiService bacSiService;

    @Autowired
    private NguoiService nguoiService;

    @Autowired
    private DatLichKhamService datLichKhamService;

    @Autowired
    private DichVuYTeService dichVuYTeService;

    @Autowired
    private LoaiThuocService loaiThuocService;

    @Autowired
    private DonThuocService donThuocService;

    @Autowired
    private LichSuKhamService lichSuKhamService;

    @Autowired
    private HoSoBeNhanService hoSoBeNhanService;

    @Autowired
    private PhieuDichVuService phieuDichVuService;

    // Trang home bác sĩ
    @GetMapping("/")
    public String home(Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        int personId = userDetails.getPersonId();
        Nguoi nguoi = userDetails.getNguoi();
        model.addAttribute("personId", personId);
        model.addAttribute("doctor", nguoi);
        return "bacsi/home";
    }

    // Xem thông tin bác sĩ đang đăng nhập
    @GetMapping("/thong-tin/{id}")
    public String xemThongTin(@PathVariable int id, Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

        Nguoi nguoi = userDetails.getNguoi();

        BacSi bs = bacSiService.getBacSiByNguoi(nguoi)
                .orElseThrow(() -> new RuntimeException("Benh nhan id " + id + " not found"));

        model.addAttribute("nguoi", nguoi);
        model.addAttribute("bacsi", bs);
        return "bacsi/thong-tin";
    }

    /**
     * BÁC SĨ đang đăng nhập xem lịch của CHÍNH MÌNH
     * /bacsi/lich-kham?mode=table|calendar
     */
    @GetMapping("/lich-kham")
    public String lichKhamCuaToi(
            @RequestParam(name = "mode", defaultValue = "table") String mode,
            Model model) {

        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        Nguoi nguoi = userDetails.getNguoi();

        BacSi bacSi = bacSiService.getBacSiByNguoi(nguoi)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thông tin bác sĩ."));

        List<DatLichKham> lichKhams = datLichKhamService.getByBacSi(bacSi);

        model.addAttribute("bacsi", bacSi);
        model.addAttribute("lichKhams", lichKhams);
        model.addAttribute("mode", mode); // table / calendar

        return "bacsi/lich-kham";
    }

    /**
     * ADMIN (hoặc người khác) xem lịch của một bác sĩ bất kỳ theo personId
     * /bacsi/lich-kham/{id}?mode=table|calendar
     */
    @GetMapping("/lich-kham/{id}")
    public String xemLichKham(
            Model model,
            @PathVariable int id,
            @RequestParam(name = "mode", defaultValue = "table") String mode) {

        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        Nguoi nguoiTruyCap = userDetails.getNguoi();
        // Tìm bác sĩ cần xem lịch từ personId
        Nguoi nguoiCanTim = nguoiService.getNguoiById(id)
                .orElseThrow(() -> new RuntimeException("Nguoi id " + id + " not found"));

        BacSi bacSiCanTim = bacSiService.getBacSiByNguoi(nguoiCanTim)
                .orElseThrow(() -> new RuntimeException("Bac si id " + id + " not found"));

        // Lấy danh sách lịch khám của bác sĩ đó
        List<DatLichKham> lichKhams = datLichKhamService.getByBacSi(bacSiCanTim);

        model.addAttribute("bacsi", bacSiCanTim);
        model.addAttribute("lichKhams", lichKhams);
        model.addAttribute("mode", mode);
        model.addAttribute("nguoi", nguoiTruyCap);
        return "bacsi/lich-kham";
    }

    // Hiển thị form cập nhật kết quả khám
    @GetMapping("/lich-kham/cap-nhat/{id}")
    public String hienThiFormCapNhat(@PathVariable int id, Model model) {
        DatLichKham lichKham = datLichKhamService.getById(id).orElse(null);
        LichSuKham lichSuKham = new LichSuKham();

        // Gán dữ liệu mặc định
        lichSuKham.setNgayKham(java.sql.Timestamp.valueOf(lichKham.getNgayKham()));
        lichSuKham.setBacSi(lichKham.getBacSi());
        lichSuKham.setPhongKham(lichKham.getKhoa().getTenKhoa());

        List<DichVuYTe> dsDichVuYTe = dichVuYTeService.getAllDichVuYTe();
        List<LoaiThuoc> dsLoaiThuoc = loaiThuocService.getAllLoaiThuoc();

        model.addAttribute("lichKham", lichKham);
        model.addAttribute("lichSuKham", lichSuKham);
        model.addAttribute("dsDichVuYTe", dsDichVuYTe);
        model.addAttribute("dsLoaiThuoc", dsLoaiThuoc);
        return "bacsi/cap-nhat-lich-kham";
    }

    @PostMapping("/lich-kham/cap-nhat/{id}")
    public String capNhatKetQua(
            @PathVariable int id,
            @RequestParam("chuanDoan") String chuanDoan,
            @RequestParam("maDichVuYTe") int maDichVuYTe,
            @ModelAttribute("lichSuKham") LichSuKham lichSuKham,

            @RequestParam(value = "thuocIds", required = false) List<Integer> thuocIds,
            @RequestParam(value = "lieuLuongs", required = false) List<String> lieuLuongs,
            @RequestParam(value = "huongDans", required = false) List<String> huongDans,

            @RequestParam(value = "ghiChuThem", required = false) String ghiChuThem,
            RedirectAttributes redirectAttributes) {

        DatLichKham dlKham = datLichKhamService.getById(id).orElseThrow();
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        BacSi bacSi = bacSiService.getBacSiByNguoi(userDetails.getNguoi()).orElseThrow();

        // 1. TÍNH TIỀN DỊCH VỤ
        DichVuYTe dichVuYTe = dichVuYTeService.getDichVuYTeById(maDichVuYTe).orElseThrow();
        PhieuDichVu phieu = new PhieuDichVu();
        phieu.setDichVuYTe(dichVuYTe);
        phieu.setSoLuong(1);
        phieuDichVuService.createPhieuDichVu(phieu);

        double giaDichVu = (dichVuYTe.getChiPhi() != null) ? dichVuYTe.getChiPhi() : 0.0;
        long tongChiPhiTinhToan = (long) giaDichVu;

        // 2. TÍNH TIỀN THUỐC
        DonThuoc donThuoc = new DonThuoc();
        List<KeDon> chiTietList = new ArrayList<>();

        if (thuocIds != null && !thuocIds.isEmpty()) {
            for (int i = 0; i < thuocIds.size(); i++) {
                KeDon ct = new KeDon();
                LoaiThuoc thuoc = loaiThuocService.getLoaiThuocById(thuocIds.get(i)).orElseThrow();

                ct.setLoaiThuoc(thuoc);
                ct.setLieuLuong(lieuLuongs.get(i));
                ct.setHuongDanSuDung(huongDans.get(i));
                ct.setDonThuoc(donThuoc);

                chiTietList.add(ct);
                tongChiPhiTinhToan += (long) thuoc.getGiaThuoc();
            }
        }

        donThuoc.setNgayKeDon(Date.from(dlKham.getNgayKham()
                .atZone(ZoneId.systemDefault()).toInstant()));
        donThuoc.setKeDon(chiTietList);
        donThuocService.createDonThuoc(donThuoc);

        // 3. LƯU LỊCH SỬ KHÁM
        lichSuKham.setDonThuoc(donThuoc);
        lichSuKham.setBacSi(bacSi);
        lichSuKham.setPhongKham(dlKham.getKhoa().getViTri());
        lichSuKham.setNgayKham(Date.from(dlKham.getNgayKham()
                .atZone(ZoneId.systemDefault()).toInstant()));
        lichSuKham.setHoSoBeNhan(hoSoBeNhanService
                .getHoSoBeNhanByBenhNhan(dlKham.getBenhNhan()).get());
        lichSuKham.setChuanDoan(chuanDoan);
        lichSuKham.setPhieuDichVu(phieu);
        lichSuKham.setGhiChu(ghiChuThem);
        lichSuKham.setChiPhi(tongChiPhiTinhToan);

        lichSuKhamService.createLichSuKham(lichSuKham);
        datLichKhamService.delete(id);

        redirectAttributes.addFlashAttribute(
                "successMessage",
                "Lưu thành công! Tổng chi phí: " + tongChiPhiTinhToan + " VNĐ"
        );
        // vẫn redirect về /bacsi/lich-kham/{personId}
        return "redirect:/bacsi/lich-kham/" + bacSi.getNguoi().getPersonId();
    }

    // 🔵 ĐÁNH DẤU LỊCH KHÁM ĐÃ HOÀN THÀNH (chỉ đổi trạng thái, không xóa)
    @PostMapping("/lich-kham/{id}/hoan-thanh")
    public String danhDauHoanThanh(
            @PathVariable int id,
            RedirectAttributes redirectAttributes) {

        try {
            DatLichKham lich = datLichKhamService.getById(id)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy lịch khám id = " + id));

            lich.setTrangThai("HOAN_THANH");

            // TODO: nếu service của bạn không có hàm save thì đổi lại tên hàm cho đúng
            datLichKhamService.save(lich);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Đã đánh dấu lịch khám của bệnh nhân "
                            + lich.getBenhNhan().getNguoi().getHoTen()
                            + " là HOÀN THÀNH."
            );
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Không thể cập nhật trạng thái: " + e.getMessage()
            );
        }

        return "redirect:/bacsi/lich-kham?mode=table";
    }

    @GetMapping("/hoso/chinh-sua/{id}")
    public String hienThiFormChinhSua(@PathVariable int id, Model model) {
        HoSoBeNhan hoSo = hoSoBeNhanService.getHoSoBeNhanById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hồ sơ có id: " + id));

        model.addAttribute("hoSo", hoSo);
        return "bacsi/chinhsuahoso";
    }

    @PostMapping("/hoso/chinh-sua/{id}")
    public String capNhatHoSo(
            @PathVariable int id,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngayNhapVien,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date ngayXuatVien,
            @RequestParam String chuanDoan,
            @RequestParam String phuongAnDieuTri,
            @RequestParam String ketQua,
            RedirectAttributes redirectAttributes) {

        try {
            HoSoBeNhan hoSo = hoSoBeNhanService.getHoSoBeNhanById(id)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy hồ sơ có id: " + id));

            hoSo.setNgayNhapVien(ngayNhapVien);
            hoSo.setNgayXuatVien(ngayXuatVien);
            hoSo.setChuanDoan(chuanDoan);
            hoSo.setPhuongAnDieuTri(phuongAnDieuTri);
            hoSo.setKetQua(ketQua);

            hoSoBeNhanService.updateHoSoBeNhan(id, hoSo);

            redirectAttributes.addFlashAttribute("successMessage",
                    "✅ Cập nhật hồ sơ bệnh án thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "❌ Lỗi khi cập nhật hồ sơ: " + e.getMessage());
        }

        return "redirect:/benhnhan/hoso/" +
                hoSoBeNhanService.getHoSoBeNhanById(id).get()
                        .getBenhNhan().getNguoi().getPersonId();
    }
}
