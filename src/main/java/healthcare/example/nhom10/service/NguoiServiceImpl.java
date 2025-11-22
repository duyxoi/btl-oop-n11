package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.Nguoi;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.NguoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NguoiServiceImpl implements NguoiService {
    @Autowired
    private NguoiRepository nguoiRepository;

    @Override
    public List<Nguoi> getAllNguoi() {
        return nguoiRepository.findAll();
    }

    @Override
    public Optional<Nguoi> getNguoiById(Integer id) {
        return nguoiRepository.findById(id);
    }

    @Override
    public Nguoi createNguoi(Nguoi nguoi) {
        return nguoiRepository.save(nguoi);
    }

    @Override
    public Nguoi updateNguoi(Integer id, Nguoi nguoiDetails) {
        // Tìm Nguoi hiện có
        Nguoi nguoi = nguoiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nguoi not found with id: " + id));

        // Cập nhật các trường
        nguoi.setCccd(nguoiDetails.getCccd());
        nguoi.setHoTen(nguoiDetails.getHoTen());
        nguoi.setGioiTinh(nguoiDetails.getGioiTinh());
        nguoi.setNgaySinh(nguoiDetails.getNgaySinh());
        nguoi.setDiaChi(nguoiDetails.getDiaChi());
        nguoi.setSdt(nguoiDetails.getSdt());
        nguoi.setEmail(nguoiDetails.getEmail());

        return nguoiRepository.save(nguoi);
    }

    @Override
    public void deleteNguoi(Integer id) {
        // Kiểm tra xem Nguoi có tồn tại không
        Nguoi nguoi = nguoiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nguoi not found with id: " + id));

        nguoiRepository.delete(nguoi);
    }

    @Override
    public boolean existsByUsername(String username) {
        return nguoiRepository.existsByUsername(username);
    }
}
