package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.BacSi;
import healthcare.example.nhom10.Entity.Nguoi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BacSiService {
    List<BacSi> getAllBacSi();
    Optional<BacSi> getBacSiById(Integer id);
    BacSi createBacSi(BacSi bacSi);
    BacSi updateBacSi(Integer id, BacSi bacSiDetails);
    void deleteBacSi(Integer id);
    Optional<BacSi> getBacSiByNguoi(Nguoi nguoi);

    // ⭐️ PHƯƠNG THỨC MỚI ĐỂ SỬA LỖI SẮP XẾP LỒNG NHAU ⭐️
    Page<BacSi> findAll(Pageable pageable);
}