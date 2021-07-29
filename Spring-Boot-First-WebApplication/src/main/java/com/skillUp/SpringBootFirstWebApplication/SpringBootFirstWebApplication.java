package com.skillUp.SpringBootFirstWebApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.skillUp.*")
public class SpringBootFirstWebApplication{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
	}
}
