package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.entity.NguoiGiamHo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiGiamHoRepository extends JpaRepository<NguoiGiamHo, Integer> {
}
