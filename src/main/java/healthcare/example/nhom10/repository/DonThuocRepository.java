package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.entity.DonThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonThuocRepository extends JpaRepository<DonThuoc, Integer> {
}
