package com.quynhtadinh.finalexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
@EnableWebSecurity
@EnableJpaRepositories("com.quynhtadinh.finalexample.repository")
@ComponentScan("com.quynhtadinh.finalexample")
public class WebSecurityConfig {

	@Autowired
	private AuthenticationConfiguration authConfiguration;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
//
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers("/resources/**", "/registration")
//		.permitAll()
////		.antMatchers("/view/**").hasAnyRole("USER", "ADMIN")
////				.antMatchers("/view/**", "/user/**").hasRole("ADMIN")
//				.anyRequest().authenticated()
//				.and().formLogin()
//				.loginPage("/login")
//				.defaultSuccessUrl("/")
//				.permitAll()
//				.and()
//				.logout()
//				.permitAll();
//
//		return http.build();
//	}
//	
	@Bean
	public SecurityFilterChain finterChain(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// Các trang không yêu cầu login
		http.authorizeRequests().antMatchers( "/resources/**", "/registration","/static/**").permitAll();
		
		http.authorizeRequests().antMatchers("/view/**","/employees/**","/user/**","/kho/**","/supplier/**","/orders/**","/category/**").access("hasAnyRole('ROLE_ADMIN')");

		http.authorizeRequests().antMatchers("/employees/**","/user/**","/kho/**","/supplier/**","/orders/**","/category/**").access("hasRole('ROLE_USER')");

		http.authorizeRequests().antMatchers("/orders/**","/customer/**").access("hasRole('ROLE_EMPLOYEE')");
		
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/405");

		// Cấu hình cho Login Form.
		
		http.authorizeRequests().anyRequest().authenticated()
		.and().formLogin()//
				// Submit URL của trang login
				.loginPage("/login")//
				.defaultSuccessUrl("/index")//
				.permitAll()
				// Cấu hình cho Logout Page.
				.and().logout().permitAll();
		return http.build();

	}

	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return authConfiguration.getAuthenticationManager();
	}

}
