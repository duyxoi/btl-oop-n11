package healthcare.example.nhom10.service;

import healthcare.example.nhom10.entity.DonThuoc;

import java.util.List;
import java.util.Optional;

public interface DonThuocService {
    List<DonThuoc> getAllDonThuoc();
    Optional<DonThuoc> getDonThuocById(Integer id);
    DonThuoc createDonThuoc(DonThuoc donThuoc);
    DonThuoc updateDonThuoc(Integer id, DonThuoc donThuocDetails);
    void deleteDonThuoc(Integer id);
}
