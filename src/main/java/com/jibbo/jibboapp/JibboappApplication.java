package com.jibbo.jibboapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.jibbo.jibboapp.repository")
public class JibboappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JibboappApplication.class, args);
	}

}
