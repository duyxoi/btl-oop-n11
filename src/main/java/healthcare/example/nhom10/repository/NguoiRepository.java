package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.Entity.Nguoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface NguoiRepository extends JpaRepository<Nguoi, Integer> {
    Optional<Nguoi> findByUsername(String username);
}
