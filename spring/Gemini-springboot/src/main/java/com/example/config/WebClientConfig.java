package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

	@Bean(name= "Geminiclient")
	WebClient GeminiWebClient() {
		return WebClient.builder()
				.baseUrl("https://generativelanguage.googleapis.com")
				.defaultHeader("content-Type", "application/json")
				.build();
	}
}
