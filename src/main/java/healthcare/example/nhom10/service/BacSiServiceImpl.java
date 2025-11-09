package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.BacSi;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.BacSiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BacSiServiceImpl implements BacSiService {
    @Autowired
    private BacSiRepository bacSiRepository;

    // Giả sử bạn cũng đã tiêm NguoiRepository và KhoaRepository nếu cần
    // để xác thực hoặc thiết lập các mối quan hệ phức tạp khi create/update.
    // @Autowired
    // private NguoiRepository nguoiRepository;
    // @Autowired
    // private KhoaRepository khoaRepository;

    @Override
    public List<BacSi> getAllBacSi() {
        return bacSiRepository.findAll();
    }

    @Override
    public Optional<BacSi> getBacSiById(Integer id) {
        return bacSiRepository.findById(id);
    }

    @Override
    public BacSi createBacSi(BacSi bacSi) {
        // Ví dụ logic kiểm tra phức tạp hơn:
        // 1. Kiểm tra xem Nguoi có tồn tại không
        // Nguoi nguoi = nguoiRepository.findById(bacSi.getNguoi().getPersonId())
        //    .orElseThrow(() -> new ResourceNotFoundException("Nguoi not found"));
        // 2. Kiểm tra xem Khoa có tồn tại không
        // Khoa khoa = khoaRepository.findById(bacSi.getKhoa().getMaKhoa())
        //    .orElseThrow(() -> new ResourceNotFoundException("Khoa not found"));
        //
        // bacSi.setNguoi(nguoi);
        // bacSi.setKhoa(khoa);

        return bacSiRepository.save(bacSi);
    }

    @Override
    public BacSi updateBacSi(Integer id, BacSi bacSiDetails) {
        // Tìm BacSi hiện có
        BacSi bacSi = bacSiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BacSi not found with id: " + id));

        // Tương tự, bạn có thể cần xác thực Nguoi và Khoa từ bacSiDetails
        // trước khi thiết lập chúng

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
}
