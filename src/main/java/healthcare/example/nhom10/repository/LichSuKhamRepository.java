package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.Entity.LichSuKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichSuKhamRepository extends JpaRepository<LichSuKham,Integer> {
}
