package com.security.practice.formlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
 * Deep explanation:
 * This class starts the third practice application. @SpringBootApplication
 * tells Spring Boot to configure the application automatically and scan this
 * package for the security configuration and controller.
 *
 * The application is intentionally small so the browser flow is easy to
 * observe: an unauthenticated request is redirected to a login page, the
 * submitted credentials are checked by the UserDetailsService, and a
 * successful login creates an authenticated session for later requests.
 */
