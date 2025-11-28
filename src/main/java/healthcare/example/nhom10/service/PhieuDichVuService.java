package healthcare.example.nhom10.service;

import healthcare.example.nhom10.entity.PhieuDichVu;

import java.util.List;
import java.util.Optional;

public interface PhieuDichVuService {
    List<PhieuDichVu> getAllPhieuDichVu();
    Optional<PhieuDichVu> getPhieuDichVuById(Integer id);
    PhieuDichVu createPhieuDichVu(PhieuDichVu phieuDichVu);
    PhieuDichVu updatePhieuDichVu(Integer id, PhieuDichVu phieuDichVuDetails);
    void deletePhieuDichVu(Integer id);
}
