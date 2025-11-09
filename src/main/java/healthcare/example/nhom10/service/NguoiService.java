package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.Nguoi;

import java.util.List;
import java.util.Optional;

public interface NguoiService {
    List<Nguoi> getAllNguoi();
    Optional<Nguoi> getNguoiById(Integer id);
    Nguoi createNguoi(Nguoi nguoi);
    Nguoi updateNguoi(Integer id, Nguoi nguoiDetails);
    void deleteNguoi(Integer id);
}
