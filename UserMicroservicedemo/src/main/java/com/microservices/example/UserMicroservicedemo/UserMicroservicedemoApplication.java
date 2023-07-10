package com.microservices.example.UserMicroservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class UserMicroservicedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMicroservicedemoApplication.class, args);
	}

}
