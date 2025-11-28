package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.BacSi;
import healthcare.example.nhom10.Entity.Nguoi;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.BacSiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BacSiServiceImpl implements BacSiService {

    // ⭐️ KHAI BÁO REPOSITORY ĐÚNG CÁCH ⭐️
    @Autowired
    private BacSiRepository bacSiRepository;

    // ... (Các Repository khác giữ nguyên nếu có) ...

    @Override
    public List<BacSi> getAllBacSi() {
        // Lưu ý: Phương thức này không nhận Pageable/Sort.
        // Đây chỉ nên dùng cho các list nhỏ không cần sắp xếp.
        return bacSiRepository.findAll();
    }

    // ⭐️ PHƯƠNG THỨC MỚI ĐỂ KHẮC PHỤC LỖI SẮP XẾP LỒNG NHAU ⭐️
    @Override
    public Page<BacSi> findAll(Pageable pageable) {
        // Phương thức này gọi findAll(Pageable) đã được override bằng @Query
        // trong BacSiRepository, giúp hỗ trợ sắp xếp lồng nhau (nguoi.hoTen).
        return bacSiRepository.findAll(pageable);
    }
    // ⭐️ KẾT THÚC FIX LỖI SẮP XẾP ⭐️

    @Override
    public Optional<BacSi> getBacSiById(Integer id) {
        return bacSiRepository.findById(id);
    }

    @Override
    public BacSi createBacSi(BacSi bacSi) {
        return bacSiRepository.save(bacSi);
    }

    @Override
    public BacSi updateBacSi(Integer id, BacSi bacSiDetails) {
        // Tìm BacSi hiện có
        BacSi bacSi = bacSiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BacSi not found with id: " + id));

        // Cập nhật các trường
        bacSi.setNguoi(bacSiDetails.getNguoi());
        bacSi.setCapDoHanhNghe(bacSiDetails.getCapDoHanhNghe());
        bacSi.setKhoa(bacSiDetails.getKhoa());

        return bacSiRepository.save(bacSi);
    }

    @Override
    public void deleteBacSi(Integer id) {
        // Kiểm tra xem BacSi có tồn tại không trước khi xóa
        BacSi bacSi = bacSiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BacSi not found with id: " + id));

        bacSiRepository.delete(bacSi);
    }

    @Override
    public Optional<BacSi> getBacSiByNguoi(Nguoi nguoi){
        return bacSiRepository.findByNguoi(nguoi);
    }
}