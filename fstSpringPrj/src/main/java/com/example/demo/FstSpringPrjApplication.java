package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.dao.EmployeeRepo;

@SpringBootApplication
public class FstSpringPrjApplication {

	public static void main(String[] args) {
		SpringApplication.run(FstSpringPrjApplication.class, args);
	}

}
