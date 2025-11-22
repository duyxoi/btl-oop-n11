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

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**", "/js/**", "/images/**","/register","/error").permitAll()
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

    // ✅ Thêm người dùng mẫu để test
//    @Bean
//    public UserDetailsService userDetailsService() {
//        var admin = User.withUsername("admin")
//                .password("{noop}123") // {noop} = không mã hoá mật khẩu
//                .roles("ADMIN")
//                .build();
//
//        var patient = User.withUsername("benhnhan")
//                .password("{noop}123")
//                .roles("PATIENT")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin, patient);
//    }

}
