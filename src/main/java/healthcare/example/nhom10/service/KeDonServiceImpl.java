package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.KeDon;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.DonThuocRepository;
import healthcare.example.nhom10.repository.KeDonRepository;
import healthcare.example.nhom10.repository.LoaiThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeDonServiceImpl implements KeDonService {
    @Autowired
    private KeDonRepository keDonRepository;

    // Tiêm các repository liên quan để xác thực
    @Autowired
    private DonThuocRepository donThuocRepository;

    @Autowired
    private LoaiThuocRepository loaiThuocRepository;

    @Override
    public List<KeDon> getAllKeDon() {
        return keDonRepository.findAll();
    }

    @Override
    public Optional<KeDon> getKeDonById(Integer id) {
        return keDonRepository.findById(id);
    }

    @Override
    public KeDon createKeDon(KeDon keDon) {
        // Logic nghiệp vụ: Kiểm tra xem DonThuoc và LoaiThuoc có tồn tại không
        // trước khi tạo bản ghi KeDon.
        if (keDon.getDonThuoc() != null) {
            donThuocRepository.findById(keDon.getDonThuoc().getMaDonThuoc())
                    .orElseThrow(() -> new ResourceNotFoundException("DonThuoc not found"));
        }

        if (keDon.getLoaiThuoc() != null) {
            loaiThuocRepository.findById(keDon.getLoaiThuoc().getMaThuoc())
                    .orElseThrow(() -> new ResourceNotFoundException("LoaiThuoc not found"));
        }

        return keDonRepository.save(keDon);
    }

    @Override
    public KeDon updateKeDon(Integer id, KeDon keDonDetails) {
        // Tìm bản ghi KeDon hiện có
        KeDon keDon = keDonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("KeDon not found with id: " + id));

        // Xác thực DonThuoc và LoaiThuoc mới (nếu chúng được cung cấp)
        if (keDonDetails.getDonThuoc() != null) {
            donThuocRepository.findById(keDonDetails.getDonThuoc().getMaDonThuoc())
                    .orElseThrow(() -> new ResourceNotFoundException("DonThuoc not found"));
        }

        if (keDonDetails.getLoaiThuoc() != null) {
            loaiThuocRepository.findById(keDonDetails.getLoaiThuoc().getMaThuoc())
                    .orElseThrow(() -> new ResourceNotFoundException("LoaiThuoc not found"));
        }

        // Cập nhật các mối quan hệ
        keDon.setDonThuoc(keDonDetails.getDonThuoc());
        keDon.setLoaiThuoc(keDonDetails.getLoaiThuoc());

        return keDonRepository.save(keDon);
    }

    @Override
    public void deleteKeDon(Integer id) {
        // Kiểm tra xem bản ghi có tồn tại không
        KeDon keDon = keDonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("KeDon not found with id: " + id));

        keDonRepository.delete(keDon);
    }
}
