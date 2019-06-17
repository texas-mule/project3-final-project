package loginhandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import sforcesoap.SObjectHandler;

/**
 * @author joshu
 *
 */
@Configuration
@EnableWebSecurity
public class AuthAppConfig extends WebSecurityConfigurerAdapter {

	private static final String USER = "USER";

	private ConnectorConfig config;
	private Properties props;
	private String username;
	private String password;

	@Autowired
	AuthAppService authAppService;

	/**
	 *
	 */
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors().and().csrf().disable();
		httpSecurity.authorizeRequests().antMatchers("/auth/login").hasRole(USER).antMatchers("/auth/register")
				.hasRole(USER).antMatchers("/auth/logusers").hasRole(USER).and().formLogin();
	}

	/**
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String password = passwordEncoder().encode("pw");
		auth.inMemoryAuthentication().withUser("un").password(password).roles(USER);
		for (Map.Entry<String, String> username : authAppService.usernamesAndPasswords().entrySet()) {
			String pw = passwordEncoder().encode(username.getValue());
			System.out.println(username.getKey());
			System.out.println(username.getValue());
			auth.inMemoryAuthentication().withUser(username.getKey()).password(pw).roles("User");
		}

	}

	/**
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * @return
	 */
	@Bean
	public SObjectHandler sObjectHandler() {
		return new SObjectHandler();
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("*"));
		corsConfig.setAllowedMethods(Arrays.asList("*"));
		corsConfig.setAllowedHeaders(Arrays.asList("*"));
		corsConfig.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}

	/**
	 * @return
	 */
	@Bean
	public EnterpriseConnection enterpriseConnection() {
		setProps();
		setConfig();
		try {
			return new EnterpriseConnection(config);
		} catch (ConnectionException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void setProps() {
		props = new Properties();
		try {
			props.load(new FileInputStream("src/connection.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		username = props.getProperty("username");
		password = props.getProperty("password") + props.getProperty("securitytoken");
	}

	private void setConfig() {
		config = new ConnectorConfig();
		config.setUsername(username);
		config.setPassword(password);
		config.setAuthEndpoint(props.getProperty("endpointurl"));
	}

}
