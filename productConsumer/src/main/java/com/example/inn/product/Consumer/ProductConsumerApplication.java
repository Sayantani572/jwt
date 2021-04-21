package com.example.inn.product.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductConsumerApplication.class, args);
	}

}
