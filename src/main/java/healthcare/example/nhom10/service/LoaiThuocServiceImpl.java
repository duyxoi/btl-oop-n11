package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.LoaiThuoc;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.LoaiThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiThuocServiceImpl implements LoaiThuocService{
    @Autowired
    private LoaiThuocRepository loaiThuocRepository;

    @Override
    public List<LoaiThuoc> getAllLoaiThuoc() {
        return loaiThuocRepository.findAll();
    }

    @Override
    public Optional<LoaiThuoc> getLoaiThuocById(Integer id) {
        return loaiThuocRepository.findById(id);
    }

    @Override
    public LoaiThuoc createLoaiThuoc(LoaiThuoc loaiThuoc) {
        return loaiThuocRepository.save(loaiThuoc);
    }

    @Override
    public LoaiThuoc updateLoaiThuoc(Integer id, LoaiThuoc loaiThuocDetails) {
        // Tìm loại thuốc hiện có
        LoaiThuoc loaiThuoc = loaiThuocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LoaiThuoc not found with id: " + id));

        // Cập nhật các trường
        loaiThuoc.setTenThuoc(loaiThuocDetails.getTenThuoc());
        loaiThuoc.setGiaThuoc(loaiThuocDetails.getGiaThuoc());
        loaiThuoc.setHanSuDung(loaiThuocDetails.getHanSuDung());

        return loaiThuocRepository.save(loaiThuoc);
    }

    @Override
    public void deleteLoaiThuoc(Integer id) {
        // Kiểm tra xem loại thuốc có tồn tại không
        LoaiThuoc loaiThuoc = loaiThuocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LoaiThuoc not found with id: " + id));

        loaiThuocRepository.delete(loaiThuoc);
    }
}
