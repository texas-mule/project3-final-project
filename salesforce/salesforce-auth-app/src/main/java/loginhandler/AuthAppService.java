package loginhandler;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.sforce.soap.enterprise.sobject.Login__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

import sforcesoap.SObjectHandler;

public class AuthAppService {

	private PasswordEncoder passwordEncoder;
	private SObjectHandler sObjectHandler;

	AuthAppService() {
		passwordEncoder = new BCryptPasswordEncoder();
		try {
			sObjectHandler = new SObjectHandler();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean newAccount(String pass, String username) {
		return sObjectHandler.saveNewSObject(loginFromUsernamePassword(username, passwordEncoder.encode(pass))) != null;
	}

	public boolean signIn(String pass, String username) {
		try {
			String existingPassword = ((Login__c) sObjectHandler
					.queryOne("SELECT Password__c FROM Login__c WHERE Username__c = '" + username + "'"))
							.getPassword__c();
			return passwordEncoder.matches(pass, existingPassword);
		} catch (ConnectionException ce) {
			ce.printStackTrace();
			return false;
		}
	}

	public void logusers() {
		try {
			for (SObject user : sObjectHandler.queryMany("SELECT Password__c, Username__c FROM Login__c")) {
				System.out.println(((Login__c) user).getUsername__c());
				System.out.println(((Login__c) user).getPassword__c());
			}
		} catch (ConnectionException ce) {
			ce.printStackTrace();
		}
	}

	private Login__c loginFromUsernamePassword(String username, String password) {
		Login__c login = new Login__c();
		login.setPassword__c(password);
		login.setUsername__c(username);
		return login;
	}

}
