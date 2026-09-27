package com.infy.security.addadmin;

import com.infy.security.entity.Users;
import com.infy.security.repo.UserDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class addAdmin {

    @Bean
    public CommandLineRunner initAdmin(UserDetailsRepository userDetailsRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userDetailsRepository.findByUsername("admin").isEmpty()) {
                Users admin = new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ROLE_ADMIN");
                userDetailsRepository.save(admin);
                System.out.println("Default admin created with username 'admin' and password 'admin123'");
            }
        };
    }
}
