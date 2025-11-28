package healthcare.example.nhom10.service;

import healthcare.example.nhom10.entity.DichVuYTe;

import java.util.List;
import java.util.Optional;

public interface DichVuYTeService {
    List<DichVuYTe> getAllDichVuYTe();
    Optional<DichVuYTe> getDichVuYTeById(Integer id);
    DichVuYTe createDichVuYTe(DichVuYTe dichVuYTe);
    DichVuYTe updateDichVuYTe(Integer id, DichVuYTe dichVuYTeDetails);
    void deleteDichVuYTe(Integer id);
}
