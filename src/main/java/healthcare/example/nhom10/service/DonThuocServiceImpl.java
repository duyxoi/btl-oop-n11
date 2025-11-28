package healthcare.example.nhom10.service;

import healthcare.example.nhom10.entity.DonThuoc;
import healthcare.example.nhom10.entity.KeDon;
import healthcare.example.nhom10.exception.ResourceNotFoundException;
import healthcare.example.nhom10.repository.DonThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DonThuocServiceImpl implements DonThuocService {
    @Autowired
    private DonThuocRepository donThuocRepository;

    // Bạn có thể tiêm KeDonRepository nếu cần logic
    // phức tạp để xác thực danh sách KeDon khi tạo/cập nhật.
    // @Autowired
    // private KeDonRepository keDonRepository;

    @Override
    public List<DonThuoc> getAllDonThuoc() {
        return donThuocRepository.findAll();
    }

    @Override
    public Optional<DonThuoc> getDonThuocById(Integer id) {
        return donThuocRepository.findById(id);
    }

    @Override
    public DonThuoc createDonThuoc(DonThuoc donThuoc) {
        // Có thể thêm logic kiểm tra danh sách KeDon ở đây
        return donThuocRepository.save(donThuoc);
    }

    @Override
    public DonThuoc updateDonThuoc(Integer id, DonThuoc donThuocDetails) {
        // Tìm đơn thuốc hiện có
        DonThuoc donThuoc = donThuocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DonThuoc not found with id: " + id));

        // Cập nhật các trường
        donThuoc.setNgayKeDon(donThuocDetails.getNgayKeDon());
        donThuoc.setKeDon(donThuocDetails.getKeDon()); // Cập nhật danh sách kê đơn

        return donThuocRepository.save(donThuoc);
    }

    @Override
    public void deleteDonThuoc(Integer id) {
        // Kiểm tra xem đơn thuốc có tồn tại không
        DonThuoc donThuoc = donThuocRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DonThuoc not found with id: " + id));

        donThuocRepository.delete(donThuoc);
    }

    @Transactional(readOnly = true)
    public Integer getGiaDonThuoc(Integer id) {
        Optional<DonThuoc> donThuoc = getDonThuocById(id);
        if(donThuoc.isPresent()) {
            DonThuoc donThuocDon = donThuoc.get();
            Long res = (long)0;
            for(KeDon x:  donThuocDon.getKeDon()){
                res = (long) (res+x.getLoaiThuoc().getGiaThuoc());
            }
            return Math.toIntExact(res);
        }
        return 0;
    }

}
