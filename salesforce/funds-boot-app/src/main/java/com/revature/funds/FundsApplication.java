package com.revature.fundsbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class FundsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundsApplication.class, args);
	}
}
