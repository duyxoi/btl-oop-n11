package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.PhieuDichVu;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.DichVuYTeRepository;
import healthcare.example.nhom10.repository.PhieuDichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhieuDichVuServiceImpl implements  PhieuDichVuService {
    @Autowired
    private PhieuDichVuRepository phieuDichVuRepository;

    @Autowired
    private DichVuYTeRepository dichVuYTeRepository; // 💡 Tiêm repository để xác thực

    @Override
    public List<PhieuDichVu> getAllPhieuDichVu() {
        return phieuDichVuRepository.findAll();
    }

    @Override
    public Optional<PhieuDichVu> getPhieuDichVuById(Integer id) {
        return phieuDichVuRepository.findById(id);
    }

    @Override
    public PhieuDichVu createPhieuDichVu(PhieuDichVu phieuDichVu) {
        // Logic nghiệp vụ: Kiểm tra xem MaDichVu có tồn tại không
        dichVuYTeRepository.findById(phieuDichVu.getMaDichVu())
                .orElseThrow(() -> new ResourceNotFoundException("DichVuYTe not found with id: " + phieuDichVu.getMaDichVu()));

        return phieuDichVuRepository.save(phieuDichVu);
    }

    @Override
    public PhieuDichVu updatePhieuDichVu(Integer id, PhieuDichVu phieuDichVuDetails) {
        // Tìm phiếu hiện có
        PhieuDichVu phieu = phieuDichVuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PhieuDichVu not found with id: " + id));

        // Xác thực MaDichVu mới
        dichVuYTeRepository.findById(phieuDichVuDetails.getMaDichVu())
                .orElseThrow(() -> new ResourceNotFoundException("DichVuYTe not found with id: " + phieuDichVuDetails.getMaDichVu()));

        // Cập nhật các trường
        phieu.setMaDichVu(phieuDichVuDetails.getMaDichVu());
        phieu.setSoLuong(phieuDichVuDetails.getSoLuong());

        return phieuDichVuRepository.save(phieu);
    }

    @Override
    public void deletePhieuDichVu(Integer id) {
        // Kiểm tra xem phiếu có tồn tại không
        PhieuDichVu phieu = phieuDichVuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PhieuDichVu not found with id: " + id));

        phieuDichVuRepository.delete(phieu);
    }
}
