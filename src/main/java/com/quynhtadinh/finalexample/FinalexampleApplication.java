package com.quynhtadinh.finalexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FinalexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalexampleApplication.class, args);
        // Create an instance of BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Encode the password
        String encodedPassword = passwordEncoder.encode("123123123");

        // Print the encoded password
        System.out.println("Encoded Password: " + encodedPassword);
	}



}
