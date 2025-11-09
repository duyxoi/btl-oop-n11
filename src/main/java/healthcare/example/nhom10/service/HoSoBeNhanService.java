package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.BenhNhan;
import healthcare.example.nhom10.Entity.HoSoBeNhan;

import java.util.List;
import java.util.Optional;

public interface HoSoBeNhanService {
    List<HoSoBeNhan> getAllHoSoBeNhan();
    Optional<HoSoBeNhan> getHoSoBeNhanById(Integer id);
    HoSoBeNhan createHoSoBeNhan(HoSoBeNhan hoSoBeNhan);
    HoSoBeNhan updateHoSoBeNhan(Integer id, HoSoBeNhan hoSoBeNhanDetails);
    void deleteHoSoBeNhan(Integer id);
    Optional<HoSoBeNhan> getHoSoBeNhanByBenhNhan(BenhNhan benhNhan);
}
