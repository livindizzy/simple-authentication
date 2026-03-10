package com.authentication.simple_authetication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SimpleAutheticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAutheticationApplication.class, args);
	}

}
