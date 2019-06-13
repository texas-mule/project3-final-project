package loginhandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sforce.ws.ConnectionException;

@RestController
@RequestMapping("/auth")
public class AuthAppController {

	AuthAppService service;

	public AuthAppController() throws ConnectionException {
		service = new AuthAppService();
	}

	@PostMapping("/register")
	public boolean register(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password) {
		return service.newAccount(password, username);
	}

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
