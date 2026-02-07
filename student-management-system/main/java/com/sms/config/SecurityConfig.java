package com.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sms.service.CustomerUserDetailsService;


@Configuration
public class SecurityConfig {
	
	private final CustomerUserDetailsService userDetailsService;
	private final JwtAuthFilter jwtAuthFilter;


    public SecurityConfig(CustomerUserDetailsService userDetailsService , JwtAuthFilter jwtAuthFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthFilter = jwtAuthFilter;
    }
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

		http
		  .addFilterBefore(jwtAuthFilter,
		       UsernamePasswordAuthenticationFilter.class);

		
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/auth/**",
						"/swagger-ui/**",
						"/v3/api-docs/**","/swagger-ui.html").permitAll()
				.requestMatchers(HttpMethod.POST, "/api/students/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/api/students/**").hasAnyRole("ADMIN","USER")

				.anyRequest().authenticated()
			);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		
		return new ProviderManager(provider);
	}

}
