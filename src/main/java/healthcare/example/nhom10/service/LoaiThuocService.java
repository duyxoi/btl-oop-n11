package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.LoaiThuoc;

import java.util.List;
import java.util.Optional;

public interface LoaiThuocService {
    List<LoaiThuoc> getAllLoaiThuoc();
    Optional<LoaiThuoc> getLoaiThuocById(Integer id);
    LoaiThuoc createLoaiThuoc(LoaiThuoc loaiThuoc);
    LoaiThuoc updateLoaiThuoc(Integer id, LoaiThuoc loaiThuocDetails);
    void deleteLoaiThuoc(Integer id);
}
