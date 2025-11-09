package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.KeDon;

import java.util.List;
import java.util.Optional;

public interface KeDonService {
    List<KeDon> getAllKeDon();
    Optional<KeDon> getKeDonById(Integer id);
    KeDon createKeDon(KeDon keDon);
    KeDon updateKeDon(Integer id, KeDon keDonDetails);
    void deleteKeDon(Integer id);
}
