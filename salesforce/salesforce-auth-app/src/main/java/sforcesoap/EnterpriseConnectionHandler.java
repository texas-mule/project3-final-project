package userloginrecordhandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.soap.enterprise.sobject.UserLoginRecord__c;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class EnterpriseConnectionHandler {

	private EnterpriseConnection connection;

	public EnterpriseConnectionHandler() {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("src/connection.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		String authEndPoint = props.getProperty("endpointurl");
		String securityToken = props.getProperty("securitytoken");
		try {
			ConnectorConfig config = new ConnectorConfig();
			config.setUsername(username);
			config.setPassword(password + securityToken);
			config.setAuthEndpoint(authEndPoint);
			connection = new EnterpriseConnection(config);
		} catch (ConnectionException ce) {
			ce.printStackTrace();
		}
	}

	public void deleteById(String id) {
		String[] ids = { id };
		try {
			connection.delete(ids);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		try {
			connection.logout();
		} catch (ConnectionException ce) {
			ce.printStackTrace();
		}
	}

	public UserLoginRecord__c saveNewUserLoginRecord(UserLoginRecord__c ulr) {
		SObject[] sObjects = { ulr };
		try {
			SaveResult[] sr = connection.create(sObjects);
			if (sr[0].getSuccess()) {
				ulr.setId(sr[0].getId());
				return ulr;
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return null;
	}

	public UserLoginRecord__c fromUsernamePassword(String username, String password) {
		UserLoginRecord__c ulr = new UserLoginRecord__c();
		ulr.setPassword__c(password);
		ulr.setUsername__c(username);
		return ulr;
	}

	public String getPasswordByUsername(String username) {
		UserLoginRecord__c ulr = new UserLoginRecord__c();
		try {
			QueryResult qr = connection
					.query("SELECT Password__c FROM UserLoginRecord__c WHERE Username__c = '" + username + "'");
			boolean done = false;
			while (qr.getSize() > 0 && !done) {
				SObject[] records = qr.getRecords();
				for (SObject so : records) {
					ulr = (UserLoginRecord__c) so;
				}
				done = qr.isDone();
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return ulr.getPassword__c();
	}

	public String saveNewUserLoginRecord(String username, String encode) {
		return saveNewUserLoginRecord(fromUsernamePassword(username, encode)).getId();
	}

	public void logUsers() {
		UserLoginRecord__c ulr = new UserLoginRecord__c();
		try {
			QueryResult qr = connection.query("SELECT Password__c, Username__c FROM UserLoginRecord__c");
			boolean done = false;
			while (qr.getSize() > 0 && !done) {
				SObject[] records = qr.getRecords();
				for (SObject so : records) {
					ulr = (UserLoginRecord__c) so;
					System.out.println(ulr.getUsername__c());
					System.out.println(ulr.getPassword__c());
				}
				done = qr.isDone();
			}
		} catch (ConnectionException e) {
			e.printStackTrace();
		}

	}

}
