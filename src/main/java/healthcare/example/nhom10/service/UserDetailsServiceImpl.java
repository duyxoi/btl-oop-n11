package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.Nguoi;
import healthcare.example.nhom10.Entity.BenhNhan; // ⭐️ Cần import Entity BenhNhan ⭐️
import healthcare.example.nhom10.common.CustomUserDetails;
import healthcare.example.nhom10.repository.NguoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private NguoiRepository nguoiRepository;

    @Autowired
    private BenhNhanService benhNhanService; // ⭐️ Khai báo BenhNhanService ⭐️

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. Tải Entity Nguoi
        Nguoi nguoi = nguoiRepository.findByUsername(username)
                .orElseThrow();

        // 2. Tải Entity BenhNhan tương ứng
        BenhNhan benhNhan = null;

        // Chỉ tải thông tin bệnh nhân nếu người dùng là PATIENT
        if ("ROLE_PATIENT".equals(nguoi.getRole())) {
            // Sử dụng Service bạn vừa hoàn thành
            benhNhan = benhNhanService.getBenhNhanByNguoi(nguoi).orElse(null);
        }

        // 3. Trả về CustomUserDetails với cả hai Entity
        // ⭐️ Đảm bảo CustomUserDetails của bạn có constructor nhận (Nguoi, BenhNhan) ⭐️
        return new CustomUserDetails(nguoi, benhNhan);
    }
}