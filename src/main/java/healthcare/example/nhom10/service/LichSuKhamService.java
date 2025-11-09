package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.LichSuKham;

import java.util.List;
import java.util.Optional;

public interface LichSuKhamService {
    List<LichSuKham> getAllLichSuKham();
    Optional<LichSuKham> getLichSuKhamById(Integer id);
    LichSuKham createLichSuKham(LichSuKham lichSuKham);
    LichSuKham updateLichSuKham(Integer id, LichSuKham lichSuKhamDetails);
    void deleteLichSuKham(Integer id);
}
