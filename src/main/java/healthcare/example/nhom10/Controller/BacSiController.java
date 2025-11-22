package healthcare.example.nhom10.Controller;

import healthcare.example.nhom10.Entity.*;
import healthcare.example.nhom10.common.CustomUserDetails;
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
    PhieuDichVuService phieuDichVuService;


    @GetMapping("/")
    public String home(Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int personId = userDetails.getPersonId();
        Nguoi nguoi = userDetails.getNguoi();
        model.addAttribute("personId", personId);
        model.addAttribute("doctor", nguoi);
        return "bacsi/home";
    }

    @GetMapping("/thong-tin/{id}")
    public String xemThongTin(@PathVariable int id, Model model) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        int personId = userDetails.getPersonId();
        Nguoi nguoi = userDetails.getNguoi();

        BacSi bs = bacSiService.getBacSiByNguoi(nguoi)
                .orElseThrow(()-> new RuntimeException("Benh nhan id "+ id+" not found"));

//        if(nguoi.getRole().equals("ROLE_PATIENT") && hoSo.getBenhNhan().getNguoi().getPersonId() != personId){
//            return "error/403";
//        }

        model.addAttribute("nguoi", nguoi);
        model.addAttribute("bacsi", bs);
        return "bacsi/thong-tin";
    }


    @GetMapping("/lich-kham/{id}")
    public String xemLichKham(Model model,@PathVariable int id) {
        // Lấy thông tin user hiện tại
        CustomUserDetails userDetails =
                (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Nguoi nguoi = userDetails.getNguoi();

        // Lấy bệnh nhân tương ứng
//        BacSi bacSi = bacSiService.getBacSiByNguoi(nguoi)
//                .orElseThrow(() -> new RuntimeException("Không tìm thấy bác sĩ."));

        Nguoi nguoiCanTim = nguoiService.getNguoiById(id).orElseThrow(()-> new RuntimeException("Nguoi id "+ id+" not found"));

        BacSi bacSiCanTim = bacSiService.getBacSiByNguoi(nguoiCanTim).orElseThrow(()-> new RuntimeException("Bac si id "+ id+" not found"));



        // Lấy danh sách lịch khám của bệnh nhân
        List<DatLichKham> lichKhams = datLichKhamService.getByBacSi(bacSiCanTim);

        model.addAttribute("nguoiDung", nguoi);
        model.addAttribute("lichKhams", lichKhams);
        return "bacsi/lich-kham"; // Giao diện hiển thị danh sách lịch khám
    }


    // Hiển thị form cập nhật
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

            // Chỉ nhận ID thuốc, Liều lượng, Hướng dẫn (ĐÃ BỎ SO_LUONGS)
            @RequestParam(value = "thuocIds", required = false) List<Integer> thuocIds,
            @RequestParam(value = "lieuLuongs", required = false) List<String> lieuLuongs,
            @RequestParam(value = "huongDans", required = false) List<String> huongDans,

            @RequestParam(value = "ghiChuThem", required = false) String ghiChuThem,
            RedirectAttributes redirectAttributes) {

        DatLichKham dlKham = datLichKhamService.getById(id).orElseThrow();
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BacSi bacSi = bacSiService.getBacSiByNguoi(userDetails.getNguoi()).orElseThrow();

        // 1. TÍNH TIỀN DỊCH VỤ
        DichVuYTe dichVuYTe = dichVuYTeService.getDichVuYTeById(maDichVuYTe).orElseThrow();
        PhieuDichVu phieu = new PhieuDichVu();
        phieu.setDichVuYTe(dichVuYTe);
        phieu.setSoLuong(1);
        phieuDichVuService.createPhieuDichVu(phieu);

        double giaDichVu = (dichVuYTe.getChiPhi() != null) ? dichVuYTe.getChiPhi() : 0.0;
        long tongChiPhiTinhToan = (long) giaDichVu;

        // 2. TÍNH TIỀN THUỐC (Không nhân số lượng)
        DonThuoc donThuoc = new DonThuoc();
        List<KeDon> chiTietList = new ArrayList<>();

        if (thuocIds != null && !thuocIds.isEmpty()) {
            for (int i = 0; i < thuocIds.size(); i++) {
                KeDon ct = new KeDon();
                LoaiThuoc thuoc = loaiThuocService.getLoaiThuocById(thuocIds.get(i)).orElseThrow();

                ct.setLoaiThuoc(thuoc);

                // Nếu Entity KeDon bắt buộc phải có số lượng, ta set cứng là 1
                // ct.setSoLuong(1);

                ct.setLieuLuong(lieuLuongs.get(i));
                ct.setHuongDanSuDung(huongDans.get(i));
                ct.setDonThuoc(donThuoc);

                chiTietList.add(ct);

                // CỘNG TIỀN: Chỉ cộng đơn giá thuốc
                tongChiPhiTinhToan += (long) thuoc.getGiaThuoc();
            }
        }

        donThuoc.setNgayKeDon(Date.from(dlKham.getNgayKham().atZone(ZoneId.systemDefault()).toInstant()));
        donThuoc.setKeDon(chiTietList);
        donThuocService.createDonThuoc(donThuoc);

        // 3. LƯU LỊCH SỬ KHÁM
        lichSuKham.setDonThuoc(donThuoc);
        lichSuKham.setBacSi(bacSi);
        lichSuKham.setPhongKham(dlKham.getKhoa().getViTri());
        lichSuKham.setNgayKham(Date.from(dlKham.getNgayKham().atZone(ZoneId.systemDefault()).toInstant()));
        lichSuKham.setHoSoBeNhan(hoSoBeNhanService.getHoSoBeNhanByBenhNhan(dlKham.getBenhNhan()).get());
        lichSuKham.setChuanDoan(chuanDoan);
        lichSuKham.setPhieuDichVu(phieu);
        lichSuKham.setGhiChu(ghiChuThem);

        // Lưu tổng tiền
        lichSuKham.setChiPhi((long) tongChiPhiTinhToan);

        lichSuKhamService.createLichSuKham(lichSuKham);
        datLichKhamService.delete(id);

        redirectAttributes.addFlashAttribute("successMessage", "Lưu thành công! Tổng chi phí: " + tongChiPhiTinhToan + " VNĐ");
        return "redirect:/bacsi/lich-kham/" + bacSi.getNguoi().getPersonId();
    }
    @GetMapping("/hoso/chinh-sua/{id}")
    public String hienThiFormChinhSua(@PathVariable int id, Model model) {
        HoSoBeNhan hoSo = hoSoBeNhanService.getHoSoBeNhanById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hồ sơ có id: " + id));

        model.addAttribute("hoSo", hoSo);
        return "bacsi/chinhsuahoso"; // Tên file HTML: chinhsuahoso.html
    }

    // 🩺 Cập nhật hồ sơ bệnh án
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
            // 🔍 Lấy hồ sơ hiện tại từ DB
            HoSoBeNhan hoSo = hoSoBeNhanService.getHoSoBeNhanById(id)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy hồ sơ có id: " + id));

            // ✏️ Cập nhật thông tin
            hoSo.setNgayNhapVien(ngayNhapVien);
            hoSo.setNgayXuatVien(ngayXuatVien);
            hoSo.setChuanDoan(chuanDoan);
            hoSo.setPhuongAnDieuTri(phuongAnDieuTri);
            hoSo.setKetQua(ketQua);

            // 💾 Lưu lại vào DB
            hoSoBeNhanService.updateHoSoBeNhan(id, hoSo);

            redirectAttributes.addFlashAttribute("successMessage", "✅ Cập nhật hồ sơ bệnh án thành công!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "❌ Lỗi khi cập nhật hồ sơ: " + e.getMessage());
        }

        // 👉 Sau khi lưu, quay lại chính trang chỉnh sửa (hiển thị thông báo)
        return "redirect:/benhnhan/hoso/" + hoSoBeNhanService.getHoSoBeNhanById(id).get().getBenhNhan().getNguoi().getPersonId();
    }

}
