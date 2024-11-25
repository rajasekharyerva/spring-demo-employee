package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/h2-console","/employees", "/employee-list").permitAll() // Allow access to H2 console
                        .anyRequest().authenticated() // Secure other endpoints
                )
                .csrf(csrf -> csrf.disable()) // Disable CSRF for H2 console
                .headers(headers -> headers.frameOptions(frame -> frame.disable())); // Allow frames for H2 console

        return http.build();
    }
}
