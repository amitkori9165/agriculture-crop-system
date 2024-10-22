package com.dealers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DealerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerServiceApplication.class, args);
		System.out.println("Dealer service is working....!");
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
