package healthcare.example.nhom10.common;

import healthcare.example.nhom10.Entity.Nguoi;
import healthcare.example.nhom10.repository.NguoiRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final Nguoi nguoi;

    public CustomUserDetails(Nguoi nguoi) {
        this.nguoi = nguoi;
    }

    public Nguoi getNguoi() {
        return nguoi;
    }

    public int getPersonId() {
        return nguoi.getPersonId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
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
