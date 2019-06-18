package loginhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author joshu
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthAppController {

	@Autowired
	AuthAppService service;

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("/register")
	public boolean register(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password) {
		System.out.println(username+password);
		return service.newAccount(password, username);
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	@PostMapping("/login")
	public boolean login(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password) {
		return service.signIn(password, username);
	}

	@GetMapping("/logusers")
	public void logusers() {
		service.logusers();
	}

}
