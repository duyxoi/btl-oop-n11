package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.BacSi;
import healthcare.example.nhom10.Entity.Khoa;

import java.util.List;
import java.util.Optional;

public interface KhoaService {
    List<Khoa> getAllKhoa();
    Optional<Khoa> getKhoaById(Integer id);
    Khoa createKhoa(Khoa khoa);
    Khoa updateKhoa(Integer id, Khoa khoaDetails);
    void deleteKhoa(Integer id);
}
