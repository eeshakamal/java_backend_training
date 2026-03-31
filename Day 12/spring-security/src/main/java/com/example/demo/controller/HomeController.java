package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@RestController
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "Welcome to public page!";
	}

	@GetMapping("/user")
	public String user() {
		return "Welcome to user page!";
	}

	@GetMapping("/admin")
	public String adminpage() {
		return "Welcome to admin page!";
	}
	@PostMapping("/register")
	public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
		return ResponseEntity.ok("User '" + request.getUsername() + "' registered successfully!");
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	static class RegisterRequest {

		@NotBlank(message = "Username can't be empty")
		@Pattern(regexp = "^[a-zA-Z]+$", message = "Username must contain only alphabets, no special characters allowed")
		private String username;

		@NotBlank(message = "Password can't be empty")
		@Pattern(
			regexp = "^(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{6,}$",
			message = "Password must be at least 6 characters with one uppercase and one special character"
		)
		private String password;

		public String getUsername() { return username; }
		public void setUsername(String username) { this.username = username; }
		public String getPassword() { return password; }
		public void setPassword(String password) { this.password = password; }
	}
}