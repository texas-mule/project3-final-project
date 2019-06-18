package loginhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sforce.soap.enterprise.sobject.Login__c;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;

import sforcesoap.SObjectHandler;

@Service
public class AuthAppService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SObjectHandler sObjectHandler;

	public boolean newAccount(String pass, String username) {
		System.out.println("Create new account: "+ username);
		System.out.println("Create new account: "+ pass);
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

	public Map<String, String> usernamesAndPasswords() {
		Map<String, String> usernames = new HashMap<String, String>();
		try {
			for (SObject user : sObjectHandler.queryMany("SELECT Username__c,Password__c FROM Login__c")) {
				Login__c loginc = (Login__c) user;
				usernames.put(loginc.getUsername__c(), loginc.getPassword__c());
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return usernames;
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
