package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.Entity.DichVuYTe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuYTeRepository extends JpaRepository<DichVuYTe, Integer> {
}
