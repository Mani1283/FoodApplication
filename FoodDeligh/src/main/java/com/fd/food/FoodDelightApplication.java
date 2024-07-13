package com.fd.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableJpaRepositories
@SpringBootApplication
@EnableWebMvc
public class FoodDelightApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDelightApplication.class, args);
	}

}
