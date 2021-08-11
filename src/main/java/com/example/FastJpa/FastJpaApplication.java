package com.example.FastJpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FastJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastJpaApplication.class, args);
	}

}
