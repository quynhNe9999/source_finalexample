package com.quynhtadinh.finalexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;


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

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	http.csrf().disable();

	// Define access for each table
	http.authorizeRequests()

			.antMatchers("/resources/**", "/registration", "/static/**","/uploads/**").permitAll()

			.antMatchers("/store/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE') or hasRole('ROLE_EMPLOYEE')")
			.antMatchers("/delete-store/**","/add-store","/edit-store/**").access("hasRole('ROLE_ADMIN')")

			.antMatchers("/employees/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE') or hasRole('ROLE_EMPLOYEE')")
			.antMatchers("/delete-employees/**","/add-employees","/edit-employees/**").access("hasRole('ROLE_ADMIN')")

			.antMatchers("/user/**","/add-user","/edit-user/").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE')")

			.antMatchers("/suppliers/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE') or hasRole('ROLE_EMPLOYEE')")
			.antMatchers("/delete-suppliers/**","/add-suppliers","/edit-suppliers/**").access("hasRole('ROLE_ADMIN')")

			.antMatchers("/category/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE') or hasRole('ROLE_EMPLOYEE')")
			.antMatchers("/delete-category/**","/add-category","/edit-category/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE')")


			.antMatchers("/customers/**","/add-customers","/edit-customers/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE') or hasRole('ROLE_EMPLOYEE') ")
			.antMatchers("/delete-customers/**","/add-customers","/edit-customers/**").access("hasRole('ROLE_ADMIN')")

			.antMatchers("/orders/**","/add-orders","/edit-orders/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE') or hasRole('ROLE_EMPLOYEE') ")
			.antMatchers("/delete-orders/**","/add-orders","/edit-orders/**").access("hasRole('ROLE_ADMIN')")

			.antMatchers("/orderDetails/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE') or hasRole('ROLE_EMPLOYEE') ")
			.antMatchers("/delete-orderDetails/**","/add-store","/edit-store/**").access("hasRole('ROLE_ADMIN')")

			.antMatchers("/imports/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE') or hasRole('ROLE_EMPLOYEE') ")
			.antMatchers("/import/**","/add-import","/edit-import/**").access("hasRole('ROLE_ADMIN')")

			.antMatchers("/products/**","/add-products","/edit-products/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGE') or hasRole('ROLE_EMPLOYEE') ")
			.antMatchers("/products/**").access("hasRole('ROLE_ADMIN')")

			.and().exceptionHandling().accessDeniedPage("/405");

	// Login configuration
	http.authorizeRequests()
			.anyRequest().authenticated()
			.and().formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/index")
			.permitAll()
			.and().logout().permitAll();

	return http.build();
}


	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

//	@Bean
//	public SecurityFilterChain finterChain(HttpSecurity http) throws Exception {
//
//		http.csrf().disable();
//
//		// Các trang không yêu cầu login
//		http.authorizeRequests()
//				.antMatchers("/resources/**", "/registration", "/static/**").permitAll()
//				.antMatchers("/view/**").access("hasRole('ROLE_ADMIN')")
//				.antMatchers("/employees/**", "/user/**", "/kho/**", "/supplier/**", "/orders/**", "/category/**")
//				.access("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGE', 'ROLE_EMPLOYEE')")
//				.antMatchers("/orders/**", "/customer/**").access("hasRole('ROLE_EMPLOYEE')")
//				.and().exceptionHandling().accessDeniedPage("/405");
//
//		// Cấu hình cho Login Form.
//		http.authorizeRequests()
//				.anyRequest().authenticated()
//				.and().formLogin()
//				.loginPage("/login")
//				.defaultSuccessUrl("/index")
//				.permitAll()
//				.and().logout().permitAll();
//
//		return http.build();
//	}




		//
//		http.csrf().disable();
//
//		// Các trang không yêu cầu login
//		http.authorizeRequests().antMatchers( "/resources/**", "/registration","/static/**").permitAll();
//
//		http.authorizeRequests().antMatchers("/view/**","/employees/**","/user/**","/kho/**","/supplier/**","/orders/**","/category/**").access("hasRole('ROLE_ADMIN')");
//
//		http.authorizeRequests().antMatchers("/employees/**","/user/**","/kho/**","/supplier/**","/orders/**","/category/**").access("hasAnyRole('ROLE_MANAGE','ROLE_EMPLOYEE')");
//
//		http.authorizeRequests().antMatchers("/orders/**","/customer/**").access("hasRole('ROLE_EMPLOYEE')");
//
//		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/405");
//
//		// Cấu hình cho Login Form.
//
//		http.authorizeRequests().anyRequest().authenticated()
//		.and().formLogin()//
//				// Submit URL của trang login
//				.loginPage("/login")//
//				.defaultSuccessUrl("/index")//
//				.permitAll()
//				// Cấu hình cho Logout Page.
//				.and().logout().permitAll();
//		return http.build();
//
//	}

	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return authConfiguration.getAuthenticationManager();
	}

}
