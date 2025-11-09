package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.Entity.BenhNhan;
import healthcare.example.nhom10.Entity.DichVuYTe;
import healthcare.example.nhom10.Entity.HoSoBeNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HoSoBeNhanRepository extends JpaRepository<HoSoBeNhan, Integer> {
    Optional<HoSoBeNhan> getHoSoBeNhanByBenhNhan(BenhNhan benhNhan);
}
