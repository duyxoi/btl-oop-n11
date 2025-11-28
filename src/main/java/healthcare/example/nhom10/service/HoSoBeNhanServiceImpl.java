package healthcare.example.nhom10.service;

import healthcare.example.nhom10.entity.BenhNhan;
import healthcare.example.nhom10.entity.HoSoBeNhan;
import healthcare.example.nhom10.entity.LichSuKham;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.HoSoBeNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HoSoBeNhanServiceImpl implements HoSoBeNhanService {
    @Autowired
    private HoSoBeNhanRepository hoSoBeNhanRepository;

    // Bạn có thể tiêm BenhNhanRepository để kiểm tra sự tồn tại của Bệnh Nhân
    // @Autowired
    // private BenhNhanRepository benhNhanRepository;

    @Override
    public List<HoSoBeNhan> getAllHoSoBeNhan() {
        return hoSoBeNhanRepository.findAll();
    }

    @Override
    public Optional<HoSoBeNhan> getHoSoBeNhanById(Integer id) {
        return hoSoBeNhanRepository.findById(id);
    }

    @Override
    @Transactional // Đảm bảo lưu đồng bộ Hồ Sơ và Lịch Sử Khám
    public HoSoBeNhan createHoSoBeNhan(HoSoBeNhan hoSoBeNhan) {
        // Kiểm tra Bệnh nhân tồn tại (nếu cần)
        // ...

        // Thiết lập mối quan hệ 2 chiều
        // Đảm bảo mọi 'LichSuKham' con đều biết 'HoSoBeNhan' cha của nó
        if (hoSoBeNhan.getLichSuKham() != null) {
            for (LichSuKham lichSuKhamItem : hoSoBeNhan.getLichSuKham()) {
                lichSuKhamItem.setHoSoBeNhan(hoSoBeNhan);
            }
        }
        return hoSoBeNhanRepository.save(hoSoBeNhan);
    }

    @Override
    @Transactional // Đảm bảo cập nhật đồng bộ
    public HoSoBeNhan updateHoSoBeNhan(Integer id, HoSoBeNhan hoSoBeNhanDetails) {
        // Tìm hồ sơ hiện có
        HoSoBeNhan hoSo = hoSoBeNhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HoSoBeNhan not found with id: " + id));

        // Cập nhật các trường thông tin cơ bản
        hoSo.setBenhNhan(hoSoBeNhanDetails.getBenhNhan());
        hoSo.setNgayNhapVien(hoSoBeNhanDetails.getNgayNhapVien());
        hoSo.setNgayXuatVien(hoSoBeNhanDetails.getNgayXuatVien());
        hoSo.setChuanDoan(hoSoBeNhanDetails.getChuanDoan());
        hoSo.setPhuongAnDieuTri(hoSoBeNhanDetails.getPhuongAnDieuTri());
        hoSo.setKetQua(hoSoBeNhanDetails.getKetQua());

        // Cập nhật danh sách Lịch Sử Khám
        // 1. Xóa Lịch Sử Khám cũ
        hoSo.getLichSuKham().clear();

        // 2. Thêm Lịch Sử Khám mới từ details
        if (hoSoBeNhanDetails.getLichSuKham() != null) {
            for (LichSuKham lskDetails : hoSoBeNhanDetails.getLichSuKham()) {
                lskDetails.setHoSoBeNhan(hoSo); // Thiết lập liên kết 2 chiều
                hoSo.getLichSuKham().add(lskDetails);
            }
        }

        return hoSoBeNhanRepository.save(hoSo);
    }

    @Override
    public void deleteHoSoBeNhan(Integer id) {
        // Kiểm tra xem hồ sơ có tồn tại không
        HoSoBeNhan hoSo = hoSoBeNhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("HoSoBeNhan not found with id: " + id));

        // Nhờ có CascadeType.ALL, khi xóa HoSoBeNhan,
        // các LichSuKham liên quan cũng sẽ tự động bị xóa.
        hoSoBeNhanRepository.delete(hoSo);
    }

    @Override
    public Optional<HoSoBeNhan> getHoSoBeNhanByBenhNhan(BenhNhan benhNhan) {
        return hoSoBeNhanRepository.getHoSoBeNhanByBenhNhan(benhNhan);
    }
}
