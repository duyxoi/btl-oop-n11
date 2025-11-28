package healthcare.example.nhom10.service;

import healthcare.example.nhom10.entity.BacSi;
import healthcare.example.nhom10.entity.DatLichKham;
import healthcare.example.nhom10.entity.BenhNhan;
import healthcare.example.nhom10.dto.LichKhamDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DatLichKhamService {
    List<DatLichKham> getAll();
    Optional<DatLichKham> getById(int id);
    DatLichKham save(DatLichKham lichKham);
    void delete(int id);
    List<DatLichKham> getByBenhNhan(BenhNhan benhNhan);
    List<DatLichKham> getByBacSi(BacSi bacSi);
    public List<LichKhamDTO> getAllMaBacSiVaNgayKham();
    public List<DatLichKham> findByBacSiAndNgayKham(int maBacSi, LocalDate ngayKham);
    public boolean existsByBacSiAndNgayKham(BacSi bacSi, LocalDateTime ngayKham);
}
