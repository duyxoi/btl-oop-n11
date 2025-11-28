package healthcare.example.nhom10.service;

import healthcare.example.nhom10.entity.BacSi;
import healthcare.example.nhom10.entity.Khoa;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.KhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class KhoaServiceImpl implements KhoaService {
    @Autowired
    private KhoaRepository khoaRepository;

    @Override
    public List<Khoa> getAllKhoa() {
        return khoaRepository.findAll();
    }

    @Override
    public Optional<Khoa> getKhoaById(Integer id) {
        return khoaRepository.findById(id);
    }

    @Override
    @Transactional // Đảm bảo lưu đồng bộ Khoa và danh sách Bác Sĩ
    public Khoa createKhoa(Khoa khoa) {
        // Thiết lập mối quan hệ 2 chiều
        // Đảm bảo mọi 'BacSi' con đều biết 'Khoa' cha của nó
        if (khoa.getBacSi() != null) {
            for (BacSi bacSi : khoa.getBacSi()) {
                bacSi.setKhoa(khoa);
            }
        }
        return khoaRepository.save(khoa);
    }

    @Override
    @Transactional // Đảm bảo cập nhật đồng bộ
    public Khoa updateKhoa(Integer id, Khoa khoaDetails) {
        // Tìm Khoa hiện có
        Khoa khoa = khoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Khoa not found with id: " + id));

        // Cập nhật các trường thông tin cơ bản
        khoa.setTenKhoa(khoaDetails.getTenKhoa());
        khoa.setViTri(khoaDetails.getViTri());

        // Cập nhật danh sách Bác Sĩ (giả sử cần `orphanRemoval = true` trong entity)
        // 1. Xóa các Bác Sĩ cũ
        khoa.getBacSi().clear();

        // 2. Thêm Bác Sĩ mới từ details
        if (khoaDetails.getBacSi() != null) {
            for (BacSi bacSiDetails : khoaDetails.getBacSi()) {
                bacSiDetails.setKhoa(khoa); // Thiết lập liên kết 2 chiều
                khoa.getBacSi().add(bacSiDetails);
            }
        }

        return khoaRepository.save(khoa);
    }

    @Override
    public void deleteKhoa(Integer id) {
        // Kiểm tra xem khoa có tồn tại không
        Khoa khoa = khoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Khoa not found with id: " + id));

        // Nhờ có CascadeType.ALL, khi xóa Khoa,
        // các BacSi thuộc khoa đó cũng sẽ tự động bị xóa.
        khoaRepository.delete(khoa);
    }

}
