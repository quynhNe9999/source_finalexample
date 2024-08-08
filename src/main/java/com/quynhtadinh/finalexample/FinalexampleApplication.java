package com.quynhtadinh.finalexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.quynhtadinh.finalexample.repository")
public class FinalexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalexampleApplication.class, args);
	}



}
