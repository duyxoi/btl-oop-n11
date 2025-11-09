package healthcare.example.nhom10.common;


import healthcare.example.nhom10.Entity.*;
import healthcare.example.nhom10.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    // 4. Tạo Bean CommandLineRunner
    @Bean
    public CommandLineRunner testKhoaRunner() {
        return args -> {
            Optional<Nguoi> optionalNguoi = nguoiService.getNguoiById(60);

            if (optionalNguoi.isEmpty()) {
                System.out.println("❌ Không tìm thấy người có ID = 35 trong cơ sở dữ liệu!");
                return;
            }

            Nguoi nguoi = optionalNguoi.get();

            Optional<BenhNhan> optionalBenhNhan = benhNhanService.getBenhNhanByNguoi(nguoi);

            if (optionalBenhNhan.isEmpty()) {
                System.out.println("⚠️ Người này chưa có hồ sơ bệnh nhân tương ứng trong bảng benhnhan!");
                return;
            }

            BenhNhan bn = optionalBenhNhan.get();
            System.out.println("✅ Bệnh nhân tìm thấy: " + bn);

            HoSoBeNhan hs = hoSoBeNhanService.getHoSoBeNhanByBenhNhan(bn).get();
            System.out.println(hs.getMaHoSo());
        };
    }

}
