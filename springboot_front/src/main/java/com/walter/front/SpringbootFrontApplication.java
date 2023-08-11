package com.walter.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringbootFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootFrontApplication.class, args);
	}

}
