package fr.formation.students.controllers;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller to deal with API accesses.
 */
@RestController
@RequestMapping("/security")
public class SecurityController {

    protected SecurityController() {
	// Default no-arg constructor
    }

    /**
     * Returns a view of the authenticated user.
     *
     * @return the principal; never {@code null}
     */
    @GetMapping("/me")
    protected Principal me() {
	return (Principal) SecurityContextHolder.getContext()
		.getAuthentication().getPrincipal();
    }

    /**
     * Redirecting endpoint for authentication flow. Invoked in case of bad
     * credentials provided.
     *
     * @return a Json serialized {@code BadCredentialsError}; never {@code null}
     */
    @RequestMapping("/authError")
    // No security, anybody can create an account (see SecurityConfig)
    protected ResponseEntity<Object> authError() {
	HttpStatus status = HttpStatus.BAD_REQUEST;
	return new ResponseEntity<>(SecurityError.of(status, "Bad credentials"),
		status);
    }

    /**
     * Redirecting endpoint for authentication flow. Invoked after logout.
     * <p>
     * This implementation does nothing.
     */
    @RequestMapping("/logout")
    // No security, anybody can create an account (see SecurityConfig)
    protected ResponseEntity<Object> logout() {
	return new ResponseEntity<>(null, HttpStatus.OK);
    }

    /**
     * Redirecting endpoint for authentication flow.
     * <p>
     * Erases the default login form.
     * <p>
     * This implementation does nothing.
     */
    @RequestMapping("/login")
    // No security, anybody can create an account (see SecurityConfig)
    protected ResponseEntity<Object> login() {
	HttpStatus status = HttpStatus.UNAUTHORIZED;
	return new ResponseEntity<>(SecurityError.of(status, "Unauthorized"),
		status);
    }
}
