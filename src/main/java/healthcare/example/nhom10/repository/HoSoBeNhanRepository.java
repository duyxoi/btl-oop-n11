package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.entity.BenhNhan;
import healthcare.example.nhom10.entity.HoSoBeNhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HoSoBeNhanRepository extends JpaRepository<HoSoBeNhan, Integer> {
    Optional<HoSoBeNhan> getHoSoBeNhanByBenhNhan(BenhNhan benhNhan);
}
