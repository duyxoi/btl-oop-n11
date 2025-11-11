package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.Entity.BacSi;
import healthcare.example.nhom10.Entity.BenhNhan;
import healthcare.example.nhom10.Entity.Nguoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
    Optional<BacSi> findByNguoi(Nguoi nguoi);
}
