package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class SqlExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlExampleApplication.class, args);
	}
}
