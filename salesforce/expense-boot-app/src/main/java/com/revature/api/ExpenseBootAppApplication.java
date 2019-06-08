package com.revature.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExpenseBootAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder sab) {
		return sab.sources(ExpenseBootAppApplication.class).properties("spring.config.name: application.expense");
	}

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application.expense");
		SpringApplication.run(ExpenseBootAppApplication.class, args);
	}

}
