package com.security.practice.formlogin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/welcome").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .defaultSuccessUrl("/dashboard", true))
                .logout(logout -> logout
                        .logoutSuccessUrl("/welcome"));

        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails learner = User.withUsername("learner")
                .password("{noop}spring123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(learner);
    }
}

/*
 * Deep explanation:
 * The SecurityFilterChain makes / and /welcome public while requiring
 * authentication for every other request. formLogin enables Spring Security's
 * standard HTML login page; defaultSuccessUrl sends a successful login to
 * /dashboard. logout invalidates the session and redirects to /welcome.
 *
 * UserDetailsService is the component Spring Security asks for user data. This
 * example returns an in-memory learner account, so it is easy to understand
 * the lookup without introducing a database. During authentication, Spring
 * compares the submitted username and password with this UserDetails object.
 * The password is marked {noop} only for practice and must be replaced with a
 * PasswordEncoder in production.
 */
