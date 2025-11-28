package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.entity.PhieuDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuDichVuRepository extends JpaRepository<PhieuDichVu, Integer> {
}
