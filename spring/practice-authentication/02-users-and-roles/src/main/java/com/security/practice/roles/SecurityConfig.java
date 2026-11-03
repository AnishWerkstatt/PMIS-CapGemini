package com.security.practice.roles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/public").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/profile").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(httpBasic -> {});

        return http.build();
    }

    @Bean
    InMemoryUserDetailsManager users() {
        UserDetails student = User.withUsername("student")
                .password("{noop}student123")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin123")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(student, admin);
    }
}

/*
 * Deep explanation:
 * @Configuration marks this class as a source of Spring beans. The
 * SecurityFilterChain bean is the ordered set of servlet filters that checks
 * every incoming request. requestMatchers are evaluated from top to bottom:
 * /public needs no login, /admin requires the ADMIN role, and /profile allows
 * either USER or ADMIN. The final rule protects any path not matched earlier.
 *
 * httpBasic enables the browser's HTTP Basic authentication dialog. The
 * InMemoryUserDetailsManager stores two users in application memory, which is
 * useful for learning but loses data when the application stops. roles("USER")
 * automatically represents the authority as ROLE_USER, which is why the
 * configuration uses hasRole("USER") rather than hasRole("ROLE_USER").
 * {noop} means Spring does not hash these practice passwords; use a password
 * encoder and a database in a real application.
 */
