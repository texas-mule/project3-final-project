package com.revature.funds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundsApplication.class, args);
	}

//	@Bean
//	@Qualifier("restingbean")
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
}
