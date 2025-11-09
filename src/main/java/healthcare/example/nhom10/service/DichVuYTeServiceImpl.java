package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.DichVuYTe;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.DichVuYTeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichVuYTeServiceImpl implements DichVuYTeService {
    @Autowired
    private DichVuYTeRepository dichVuYTeRepository;

    @Override
    public List<DichVuYTe> getAllDichVuYTe() {
        return dichVuYTeRepository.findAll();
    }

    @Override
    public Optional<DichVuYTe> getDichVuYTeById(Integer id) {
        return dichVuYTeRepository.findById(id);
    }

    @Override
    public DichVuYTe createDichVuYTe(DichVuYTe dichVuYTe) {
        return dichVuYTeRepository.save(dichVuYTe);
    }

    @Override
    public DichVuYTe updateDichVuYTe(Integer id, DichVuYTe dichVuYTeDetails) {
        // Tìm dịch vụ y tế hiện có
        DichVuYTe dichVuYTe = dichVuYTeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DichVuYTe not found with id: " + id));

        // Cập nhật các trường
        dichVuYTe.setTenDichVu(dichVuYTeDetails.getTenDichVu());
        dichVuYTe.setChiPhi(dichVuYTeDetails.getChiPhi());

        return dichVuYTeRepository.save(dichVuYTe);
    }

    @Override
    public void deleteDichVuYTe(Integer id) {
        // Kiểm tra xem dịch vụ có tồn tại không
        DichVuYTe dichVuYTe = dichVuYTeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DichVuYTe not found with id: " + id));

        dichVuYTeRepository.delete(dichVuYTe);
    }
}
