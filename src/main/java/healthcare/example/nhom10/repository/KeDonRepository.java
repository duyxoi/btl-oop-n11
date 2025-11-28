package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.entity.KeDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeDonRepository extends JpaRepository<KeDon, Integer> {
}
