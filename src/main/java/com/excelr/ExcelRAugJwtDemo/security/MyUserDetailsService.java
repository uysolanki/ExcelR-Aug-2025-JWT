package com.excelr.ExcelRAugJwtDemo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {

        if (username.equals("alice")) {
            return User.builder()
                    .username("alice")
                    .password(new BCryptPasswordEncoder().encode("alice"))
                    .authorities("ADMIN")
                    .build();
        }

        return User.builder()
                .username("ben")
                .password(new BCryptPasswordEncoder().encode("ben"))
                .authorities("USER")
                .build();
    }
}

//welcome ADMIN & USER
//greet   ADMIN only