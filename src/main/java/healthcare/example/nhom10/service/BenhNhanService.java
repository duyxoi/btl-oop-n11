package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.BenhNhan;
import healthcare.example.nhom10.Entity.Nguoi;

import java.util.List;
import java.util.Optional;

public interface BenhNhanService {
    List<BenhNhan> getAllBenhNhan();
    Optional<BenhNhan> getBenhNhanById(Integer id);
    Optional<BenhNhan> getBenhNhanByNguoi(Nguoi nguoi);
    BenhNhan createBenhNhan(BenhNhan benhNhan);
    BenhNhan updateBenhNhan(Integer id, BenhNhan benhNhanDetails);
    void deleteBenhNhan(Integer id);
    List<BenhNhan> findByCccd(String cccd) ;

    List<BenhNhan> sortByHoTen() ;

    List<BenhNhan> sortByNgaySinh() ;

     List<BenhNhan> sortByMaBenhNhan() ;
}
