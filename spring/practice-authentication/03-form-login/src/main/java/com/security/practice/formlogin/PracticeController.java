package com.security.practice.formlogin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {

    @GetMapping({"/", "/welcome"})
    public String welcome() {
        return "Welcome. Visit /dashboard and Spring will ask you to log in.";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "You reached the protected dashboard.";
    }
}

/*
 * Deep explanation:
 * The two welcome mappings are public because SecurityConfig explicitly
 * permits them. The dashboard method is protected by the catch-all
 * authenticated rule, so an unauthenticated browser is redirected to the
 * generated login page before this method executes.
 *
 * Notice that this controller contains no session or password code. Spring
 * Security manages authentication outside the controller and makes the
 * authenticated result available to the rest of the application. This keeps
 * business endpoints focused on returning application data rather than
 * reimplementing security logic.
 */
