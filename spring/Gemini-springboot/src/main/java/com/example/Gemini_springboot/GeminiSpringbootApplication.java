package com.example.Gemini_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class GeminiSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeminiSpringbootApplication.class, args);
	}

}
