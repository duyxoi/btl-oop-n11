package healthcare.example.nhom10.repository;

import healthcare.example.nhom10.Entity.BacSi;
import healthcare.example.nhom10.Entity.DatLichKham;
import healthcare.example.nhom10.Entity.BenhNhan;
import healthcare.example.nhom10.dto.LichKhamDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface DatLichKhamRepository extends JpaRepository<DatLichKham, Integer> {
    List<DatLichKham> findByBenhNhan(BenhNhan benhNhan);
    List<DatLichKham> findByBacSi(BacSi bacSi);

    @Query("SELECT new healthcare.example.nhom10.dto.LichKhamDTO(d.bacSi.maBacSi, d.ngayKham) FROM DatLichKham d")
    List<LichKhamDTO> findAllMaBacSiVaNgayKham();

    @Query("SELECT d FROM DatLichKham d " +
            "WHERE d.bacSi.maBacSi = :maBacSi " +
            "AND DATE(d.ngayKham) = :ngayKham " +
            "AND d.trangThai = 'DA_XAC_NHAN'")
    List<DatLichKham> findByBacSiAndNgayKham(@Param("maBacSi") int  maBacSi,
                                             @Param("ngayKham") LocalDate ngayKham);

    @Query("SELECT COUNT(d) > 0 FROM DatLichKham d " +
            "WHERE d.bacSi.maBacSi = :maBacSi " +
            "AND d.ngayKham = :ngayKham")
    boolean existsByBacSiAndNgayKham(@Param("maBacSi") int maBacSi,
                                     @Param("ngayKham") LocalDateTime ngayKham);

    boolean existsByBacSiAndNgayKham(BacSi bacSi, LocalDateTime ngayKham);


}
