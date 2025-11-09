package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.Entity.LoaiThuoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiThuocRepository extends JpaRepository<LoaiThuoc,Integer> {
}
