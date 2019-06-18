package sforcesoap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

public class EnterpriseConnectionHandler {

	private EnterpriseConnection connection;
	private ConnectorConfig config;
	private Properties props;
	private ScheduledExecutorService executorService;
	private String username;
	private String password;
	Runnable queryTask;

	EnterpriseConnectionHandler() throws ConnectionException, FileNotFoundException, IOException {
		setProps();
		setConfig();
		setQueryTask();
		connection = new EnterpriseConnection(config);
		executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.schedule(queryTask, 37, TimeUnit.MINUTES);
	}

	EnterpriseConnection getConnection() {
		return connection;
	}

	private void setProps() throws FileNotFoundException, IOException {
		props = new Properties();
		props.load(new FileInputStream("src/connection.properties"));
		username = props.getProperty("username");
		password = props.getProperty("password") + props.getProperty("securitytoken");
	}

	private void setConfig() {
		config = new ConnectorConfig();
		config.setUsername(username);
		config.setPassword(password);
		config.setAuthEndpoint(props.getProperty("endpointurl"));
	}

	private void setQueryTask() {
		queryTask = () -> {
			try {
				connection.query("Select * From Account");
			} catch (ConnectionException e) {
				e.printStackTrace();
			}
		};
	}

}
