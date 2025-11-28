package healthcare.example.nhom10.service;

import healthcare.example.nhom10.entity.BacSi;
import healthcare.example.nhom10.entity.DatLichKham;
import healthcare.example.nhom10.entity.BenhNhan;
import healthcare.example.nhom10.dto.LichKhamDTO;
import healthcare.example.nhom10.repository.DatLichKhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DatLichKhamServiceImpl implements DatLichKhamService {

    @Autowired
    private DatLichKhamRepository datLichKhamRepository;

    @Override
    public List<DatLichKham> getAll() {
        return datLichKhamRepository.findAll();
    }

    @Override
    public Optional<DatLichKham> getById(int id) {
        return datLichKhamRepository.findById(id);
    }

    @Override
    public DatLichKham save(DatLichKham lichKham) {
        return datLichKhamRepository.save(lichKham);
    }

    @Override
    public void delete(int id) {
        datLichKhamRepository.deleteById(id);
    }

    @Override
    public List<DatLichKham> getByBenhNhan(BenhNhan benhNhan) {
        return datLichKhamRepository.findByBenhNhan(benhNhan);
    }

    public List<LichKhamDTO> getAllMaBacSiVaNgayKham(){
        return datLichKhamRepository.findAllMaBacSiVaNgayKham();
    }
    public List<DatLichKham> findByBacSiAndNgayKham(int maBacSi, LocalDate ngayKham) {
        return datLichKhamRepository.findByBacSiAndNgayKham(maBacSi, ngayKham);
    }

    public DatLichKham createLichKham(DatLichKham lichMoi) {
        boolean trung = datLichKhamRepository.existsByBacSiAndNgayKham(
                lichMoi.getBacSi().getMaBacSi(),
                lichMoi.getNgayKham()
        );

        if (trung) {
            throw new IllegalArgumentException("Bác sĩ này đã có lịch vào khung giờ đó!");
        }

        return datLichKhamRepository.save(lichMoi);
    }

    @Override
    public boolean existsByBacSiAndNgayKham(BacSi bacSi, LocalDateTime ngayKham) {
        return datLichKhamRepository.existsByBacSiAndNgayKham(bacSi, ngayKham);
    }

    @Override
    public List<DatLichKham> getByBacSi(BacSi bacSi) {
        return datLichKhamRepository.findByBacSi(bacSi);
    }
}
