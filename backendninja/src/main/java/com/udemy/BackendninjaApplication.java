package com.udemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling // anotacion para permitir usar anotacion Schedule, como la clase TaskComponent.java
public class BackendninjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendninjaApplication.class, args);
	}
}
