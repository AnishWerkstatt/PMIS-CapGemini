package com.security.practice.roles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {

    @GetMapping("/public")
    public String publicPage() {
        return "Anyone can see this page.";
    }

    @GetMapping("/profile")
    public String profile() {
        return "A logged-in user can see this profile.";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Only an ADMIN can see this page.";
    }
}

/*
 * Deep explanation:
 * @RestController makes each method an HTTP endpoint whose return value is
 * written into the response body. The controller does not perform login
 * checks itself. Instead, the SecurityFilterChain runs before the request
 * reaches these methods and decides whether the request is allowed.
 *
 * This separation is a key Spring Security idea: controllers describe what
 * the application does, while the security configuration describes who may
 * access it. Try /public without credentials, then use student/student123 for
 * /profile and admin/admin123 for /admin. The student account should receive
 * an authorization failure for /admin because it has USER but not ADMIN.
 */
