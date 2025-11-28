package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.Entity.BacSi;
import healthcare.example.nhom10.Entity.Nguoi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Cần import Pageable
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // Cần import Query
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {

    // Phương thức tìm kiếm theo Nguoi (giữ nguyên)
    Optional<BacSi> findByNguoi(Nguoi nguoi);

    // ⭐️ KHẮC PHỤC LỖI SẮP XẾP LỒNG NHAU (nguoi.hoTen) ⭐️
    // Ghi đè phương thức findAll(Pageable) để buộc LEFT JOIN FETCH
    // Điều này đảm bảo Entity Nguoi được tải và cho phép sắp xếp trên các trường của Nguoi
    @Override
    @Query("SELECT bs FROM BacSi bs LEFT JOIN FETCH bs.nguoi")
    Page<BacSi> findAll(Pageable pageable);

    // Lưu ý: Để phương thức này hoạt động, Service của bạn phải gọi findAll(Pageable)
}