package com.security.practice.roles;

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
 * This is the entry point of the second practice application. The
 * @SpringBootApplication annotation starts component scanning, so Spring will
 * find SecurityConfig and PracticeController in the same package or a child
 * package. SpringApplication.run creates the application context and starts
 * the embedded server.
 *
 * Keeping this class separate from the other examples is important: each
 * example has its own application context and its own security rules. Running
 * this class therefore demonstrates only the users, roles, and URL rules
 * defined in this project.
 */
