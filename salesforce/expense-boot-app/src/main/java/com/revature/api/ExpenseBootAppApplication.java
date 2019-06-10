package com.revature.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author sweinhart
 *
 */
@SpringBootApplication
public class ExpenseBootAppApplication extends SpringBootServletInitializer {

	/* (non-Javadoc)
	 * @see org.springframework.boot.web.servlet.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder sab) {
		return sab.sources(ExpenseBootAppApplication.class).properties("spring.config.name: application.expense");
	}

	/**
	 * Start the Spring Boot Expense Service
	 * 
	 * @param args : No arguments
	 */
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application.expense");
		SpringApplication.run(ExpenseBootAppApplication.class, args);
	}

}
