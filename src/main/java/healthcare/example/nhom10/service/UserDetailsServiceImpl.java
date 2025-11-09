package healthcare.example.nhom10.service;

import healthcare.example.nhom10.Entity.Nguoi;
import healthcare.example.nhom10.common.CustomUserDetails;
import healthcare.example.nhom10.repository.NguoiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private NguoiRepository nguoiRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Nguoi nguoi = nguoiRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy người dùng: " + username));

        return new CustomUserDetails(nguoi);
    }
}
