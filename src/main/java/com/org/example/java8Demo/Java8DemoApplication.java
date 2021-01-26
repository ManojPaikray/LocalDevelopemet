package com.org.example.java8Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Java8DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java8DemoApplication.class, args);
	}
}
