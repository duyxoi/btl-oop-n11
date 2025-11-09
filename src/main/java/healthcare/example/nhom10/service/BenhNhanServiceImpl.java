package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.BenhNhan;
import healthcare.example.nhom10.Entity.Nguoi;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.BenhNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenhNhanServiceImpl implements BenhNhanService {
    @Autowired
    private BenhNhanRepository benhNhanRepository;

    // Bạn cũng có thể tiêm NguoiRepository và NguoiGiamHoRepository
    // để kiểm tra sự tồn tại của Nguoi và NguoiGiamHo trước khi tạo/cập nhật
    // @Autowired
    // private NguoiRepository nguoiRepository;
    // @Autowired
    // private NguoiGiamHoRepository nguoiGiamHoRepository;

    @Override
    public List<BenhNhan> getAllBenhNhan() {
        return benhNhanRepository.findAll();
    }

    @Override
    public Optional<BenhNhan> getBenhNhanById(Integer id) {
        return benhNhanRepository.findById(id);
    }

    @Override
    public Optional<BenhNhan> getBenhNhanByNguoi(Nguoi nguoi) {
        return benhNhanRepository.findByNguoi(nguoi);
    }

    @Override
    public BenhNhan createBenhNhan(BenhNhan benhNhan) {
        // Có thể thêm logic kiểm tra Nguoi, NguoiGiamHo tồn tại ở đây
        return benhNhanRepository.save(benhNhan);
    }

    @Override
    public BenhNhan updateBenhNhan(Integer id, BenhNhan benhNhanDetails) {
        // Tìm bệnh nhân hiện có
        BenhNhan benhNhan = benhNhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BenhNhan not found with id: " + id));

        // Cập nhật các trường
        benhNhan.setNguoi(benhNhanDetails.getNguoi());
        benhNhan.setNguoiGiamHo(benhNhanDetails.getNguoiGiamHo());
        benhNhan.setNhomMau(benhNhanDetails.getNhomMau());
        benhNhan.setTienSuBenh(benhNhanDetails.getTienSuBenh());
        benhNhan.setMaBaoHiem(benhNhanDetails.getMaBaoHiem());

        return benhNhanRepository.save(benhNhan);
    }

    @Override
    public void deleteBenhNhan(Integer id) {
        // Kiểm tra xem bệnh nhân có tồn tại không
        BenhNhan benhNhan = benhNhanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BenhNhan not found with id: " + id));

        benhNhanRepository.delete(benhNhan);
    }
}
