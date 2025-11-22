package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.LichSuKham;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LichSuKhamServiceImpl implements LichSuKhamService {
    @Autowired
    private LichSuKhamRepository lichSuKhamRepository;

    // Tiêm các repository liên quan để xác thực khóa ngoại
    @Autowired
    private BacSiRepository bacSiRepository;

    @Autowired
    private DonThuocRepository donThuocRepository;

    @Autowired
    private HoSoBeNhanRepository hoSoBeNhanRepository;

    @Autowired
    private PhieuDichVuRepository phieuDichVuRepository; // (Bạn cần tạo repository này)


    @Override
    public List<LichSuKham> getAllLichSuKham() {
        return lichSuKhamRepository.findAll();
    }

    @Override
    public Optional<LichSuKham> getLichSuKhamById(Integer id) {
        return lichSuKhamRepository.findById(id);
    }

    @Override
    public LichSuKham createLichSuKham(LichSuKham lichSuKham) {
        // Logic nghiệp vụ: Kiểm tra sự tồn tại của các đối tượng liên quan
        validateRelatedEntities(lichSuKham);
        return lichSuKhamRepository.save(lichSuKham);
    }

    @Override
    public LichSuKham updateLichSuKham(Integer id, LichSuKham lichSuKhamDetails) {
        // Tìm bản ghi Lịch Sử Khám hiện có
        LichSuKham lichSuKham = lichSuKhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LichSuKham not found with id: " + id));

        // Xác thực các đối tượng liên quan mới
        validateRelatedEntities(lichSuKhamDetails);

        // Cập nhật các trường
        lichSuKham.setBacSi(lichSuKhamDetails.getBacSi());
        lichSuKham.setDonThuoc(lichSuKhamDetails.getDonThuoc());
        lichSuKham.setHoSoBeNhan(lichSuKhamDetails.getHoSoBeNhan());
        lichSuKham.setPhieuDichVu(lichSuKhamDetails.getPhieuDichVu());
        lichSuKham.setNgayKham(lichSuKhamDetails.getNgayKham());
        lichSuKham.setPhongKham(lichSuKhamDetails.getPhongKham());
        lichSuKham.setGhiChu(lichSuKhamDetails.getGhiChu());
        lichSuKham.setChiPhi(lichSuKhamDetails.getChiPhi());

        return lichSuKhamRepository.save(lichSuKham);
    }

    @Override
    public void deleteLichSuKham(Integer id) {
        // Kiểm tra xem bản ghi có tồn tại không
        LichSuKham lichSuKham = lichSuKhamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LichSuKham not found with id: " + id));

        lichSuKhamRepository.delete(lichSuKham);
    }

    /**
     * Hàm helper để kiểm tra sự tồn tại của các khóa ngoại
     */
    private void validateRelatedEntities(LichSuKham lichSuKham) {
        if (lichSuKham.getBacSi() != null) {
            bacSiRepository.findById(lichSuKham.getBacSi().getMaBacSi())
                    .orElseThrow(() -> new ResourceNotFoundException("BacSi not found"));
        }
        if (lichSuKham.getDonThuoc() != null) {
            donThuocRepository.findById(lichSuKham.getDonThuoc().getMaDonThuoc())
                    .orElseThrow(() -> new ResourceNotFoundException("DonThuoc not found"));
        }
        if (lichSuKham.getHoSoBeNhan() != null) {
            hoSoBeNhanRepository.findById(lichSuKham.getHoSoBeNhan().getMaHoSo())
                    .orElseThrow(() -> new ResourceNotFoundException("HoSoBeNhan not found"));
        }
        if (lichSuKham.getPhieuDichVu() != null) {
            // Giả sử PhieuDichVu có getId() hoặc getMaSoPhieu()
            phieuDichVuRepository.findById(lichSuKham.getPhieuDichVu().getMaSoPhieu())
                    .orElseThrow(() -> new ResourceNotFoundException("PhieuDichVu not found"));
        }
    }
}
