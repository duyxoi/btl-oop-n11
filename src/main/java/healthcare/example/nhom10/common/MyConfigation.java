package healthcare.example.nhom10.common;


import healthcare.example.nhom10.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigation {
    // 3. Tiêm (Inject) KhoaService
    @Autowired
    private KhoaServiceImpl khoaServiceImpl;

    @Autowired
    private NguoiService  nguoiService;

    @Autowired
    private DonThuocServiceImpl donThuocServiceImpl;

    @Autowired
    private BenhNhanService benhNhanService;

    @Autowired
    private HoSoBeNhanService hoSoBeNhanService;

    @Autowired
    private LichSuKhamService lichSuKhamService;

    // 4. Tạo Bean CommandLineRunner
    @Bean
    public CommandLineRunner testKhoaRunner() {
        return args -> {
//           List<LichSuKham> lichSuKhams = lichSuKhamService.getAllLichSuKham();
//           for(LichSuKham ls : lichSuKhams) {
//               long tongChiPhi = 0;
//               List<KeDon> dt = ls.getDonThuoc().getKeDon();
//               for(KeDon d : dt) {
//                   tongChiPhi+= d.getLoaiThuoc().getGiaThuoc();
//               }
//               tongChiPhi+=ls.getPhieuDichVu().getDichVuYTe().getChiPhi();
//               System.out.println(ls.getMaLichSuKham()+" "+ls.getHoSoBeNhan().getBenhNhan().getNguoi().getHoTen()+" tong chi phi la "+tongChiPhi);
//               ls.setChiPhi(tongChiPhi);
//               lichSuKhamService.updateLichSuKham(ls.getMaLichSuKham(),ls);

           //}
            System.out.println("Hello World");
        };
    }

}
