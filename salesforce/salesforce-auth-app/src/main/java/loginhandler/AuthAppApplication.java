package loginhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author joshu
 *
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }, scanBasePackages = "loginhandler")
public class AuthAppApplication extends SpringBootServletInitializer {

	/**
	 *
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder sab) {
		return sab.sources(AuthAppApplication.class).properties("spring.config.name: application.login");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "application.login");
		SpringApplication.run(AuthAppApplication.class, args);
	}

}
