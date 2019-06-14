package userloginrecordhandler;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthAppService {

	PasswordEncoder passwordEncoder;

	AuthAppService() {
		passwordEncoder = new BCryptPasswordEncoder();
	}

	private EnterpriseConnectionHandler enterpriseConnectionHandler = new EnterpriseConnectionHandler();

	public boolean newAccount(String pass, String username) {
		return enterpriseConnectionHandler.saveNewUserLoginRecord(username, passwordEncoder.encode(pass)) != null;
	}

	public boolean signIn(String pass, String username) {
		String existingPassword = enterpriseConnectionHandler.getPasswordByUsername(username);

		return passwordEncoder.matches(pass, existingPassword);

	}

	public void logusers() {
		enterpriseConnectionHandler.logUsers();
	}

}
