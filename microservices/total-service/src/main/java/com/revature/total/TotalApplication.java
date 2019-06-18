package com.revature.total;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * 
 * @author david
 * The TotalApplication is used for running Spring Boot   
 *
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableDiscoveryClient
public class TotalApplication {
	/**
	 * Runs Spring Boot app
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TotalApplication.class, args);
	}

}
