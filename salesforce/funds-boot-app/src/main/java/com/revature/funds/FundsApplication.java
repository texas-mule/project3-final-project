package com.revature.funds;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
