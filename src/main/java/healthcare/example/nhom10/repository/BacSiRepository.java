package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.Entity.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
}
