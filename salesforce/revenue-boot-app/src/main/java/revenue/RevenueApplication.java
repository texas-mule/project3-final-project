package revenue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RevenueApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application.revenue");
		SpringApplication.run(RevenueApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder stockapp) {
		return stockapp.sources(RevenueApplication.class).properties("spring.config.name: application.revenue)");
	}

}
