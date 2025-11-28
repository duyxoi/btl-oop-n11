package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.entity.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaRepository extends JpaRepository<Khoa, Integer> {
}
