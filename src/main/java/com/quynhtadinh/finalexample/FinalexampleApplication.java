package com.quynhtadinh.finalexample;

import com.quynhtadinh.finalexample.entity.Role;
import com.quynhtadinh.finalexample.repository.RoleRepository;
import com.quynhtadinh.finalexample.util.LogUtils;
import com.quynhtadinh.finalexample.util.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
//@ComponentScan(basePackages = "com.quynhtadinh.finalexample")
@EnableJpaRepositories("com.quynhtadinh.finalexample.repository")
@ComponentScan("com.quynhtadinh.finalexample")
public class FinalexampleApplication {

	public FinalexampleApplication() {
		// Default constructor
	}
    public static void main(String[] args) {
		SpringApplication app = new SpringApplication(FinalexampleApplication.class);
		Map<String, Object> defProperties = new HashMap<>();
		defProperties.put("spring.profiles.default", "dev");
		app.setDefaultProperties(defProperties);
		Environment env = app.run(args).getEnvironment();
		LogUtils.logApplicationStartup(env);
	}


    public static FinalexampleApplication createFinalexampleApplication() {
        return new FinalexampleApplication();
    }
}
