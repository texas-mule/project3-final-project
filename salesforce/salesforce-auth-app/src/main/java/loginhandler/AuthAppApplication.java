package loginhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author joshu
 *
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }, scanBasePackages = "loginhandler")
public class AuthAppApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthAppApplication.class, args);
	}

}
