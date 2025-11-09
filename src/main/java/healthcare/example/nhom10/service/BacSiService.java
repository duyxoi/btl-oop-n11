package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.BacSi;
import healthcare.example.nhom10.Entity.PhieuDichVu;

import java.util.List;
import java.util.Optional;

public interface BacSiService {
        List<BacSi> getAllBacSi();
        Optional<BacSi> getBacSiById(Integer id);
        BacSi createBacSi(BacSi bacSi);
        BacSi updateBacSi(Integer id, BacSi bacSiDetails);
        void deleteBacSi(Integer id);

}
