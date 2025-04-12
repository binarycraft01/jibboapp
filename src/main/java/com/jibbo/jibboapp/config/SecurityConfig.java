package com.jibbo.jibboapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (POST 허용)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/signup").permitAll() // 회원가입 허용
                        .anyRequest().authenticated() // 나머지는 인증 필요
                );

        return http.build();
    }
}
