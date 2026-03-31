package com.example.demo.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/", "/register", "/login").permitAll()
				.requestMatchers("/user").hasRole("USER")
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.successHandler(customSuccessHandler())
				.permitAll()
			)
			.logout(logout -> logout.permitAll())
			.exceptionHandling(ex -> ex
				.accessDeniedHandler((request, response, accessDeniedException) -> {
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					response.getWriter().write("Access Denied: You do not have permission to access this page.");
				})
			);
		return http.build();
	}
	@Bean
	public AuthenticationSuccessHandler customSuccessHandler() {
		return (HttpServletRequest request, HttpServletResponse response, Authentication authentication) -> {
			boolean isAdmin = authentication.getAuthorities().stream()
				.anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
			if (isAdmin) {
				response.sendRedirect("/admin");
			} else {
				response.sendRedirect("/user");
			}
		};
	}
}