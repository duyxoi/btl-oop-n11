package healthcare.example.nhom10.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // (Bỏ qua cấu hình PasswordEncoder nếu đang sử dụng {noop})

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // ⛔️ SỬA ĐỔI QUAN TRỌNG: Thêm đường dẫn gốc ("/") và "/index" vào permitAll() ⛔️
                        .requestMatchers("/", "/index", "/login", "/css/**", "/js/**", "/images/**","/register","/error").permitAll()

                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/bacsi/lich-kham/**").hasAnyRole("DOCTOR","ADMIN")
                        .requestMatchers("/bacsi/**").hasRole("DOCTOR")
                        .requestMatchers("/benhnhan/hoso/**").hasAnyRole("DOCTOR","PATIENT","ADMIN")
                        .requestMatchers("/benhnhan/**").hasRole("PATIENT")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .successHandler(new CustomAuthenticationSuccessHandler())  // 👈 dùng handler tùy chỉnh
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // tạm tắt CSRF nếu đang test

        return http.build();
    }
}