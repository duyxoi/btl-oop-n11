package healthcare.example.nhom10.common;

import healthcare.example.nhom10.Entity.BenhNhan;
import healthcare.example.nhom10.Entity.Nguoi;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final Nguoi nguoi;
    private final BenhNhan benhNhan; // ⭐️ ĐÃ THÊM FIELD BENHNHAN ⭐️

    // ⭐️ CONSTRUCTOR MỚI ĐỂ NHẬN CẢ NGUOI VÀ BENHNHAN ⭐️
    public CustomUserDetails(Nguoi nguoi, BenhNhan benhNhan) {
        this.nguoi = nguoi;
        this.benhNhan = benhNhan; // GÁN GIÁ TRỊ TỪ UserDetailsServiceImpl
    }

    // ******************************************************
    // 1. GETTERS CHO THYMELEAF (DỮ LIỆU CÁ NHÂN)
    // ******************************************************

    public Nguoi getNguoi() {
        return nguoi;
    }

    // ⭐️ GETTER CẦN THIẾT CHO THYMELEAF TRUY CẬP THÔNG TIN Y TẾ ⭐️
    public BenhNhan getBenhNhan() {
        return benhNhan;
    }

    public int getPersonId() {
        return nguoi.getPersonId();
    }

    // ******************************************************
    // 2. PHƯƠNG THỨC BẮT BUỘC CỦA USERDETAILS
    // ******************************************************

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Trả về Role (ROLE_PATIENT, ROLE_DOCTOR,...)
        return List.of(new SimpleGrantedAuthority(nguoi.getRole()));
    }

    @Override
    public String getPassword() {
        return nguoi.getPassword();
    }

    @Override
    public String getUsername() {
        return nguoi.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return nguoi.isEnabled();
    }
}