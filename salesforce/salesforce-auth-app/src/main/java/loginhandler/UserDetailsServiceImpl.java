package loginhandler;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	AuthAppService authAppService;
	
	List<UserDetails> listUserDetails;

	UserDetailsServiceImpl(List<UserDetails> listUserDetails) {
		this.listUserDetails = listUserDetails;
	}
	

	public void setListUserDetails(List<UserDetails> listUserDetails) {
		this.listUserDetails = listUserDetails;
	}


	public UserDetailsServiceImpl() {
		super();
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		listUserDetails = new LinkedList<UserDetails>();
		System.out.println("Load user:"+username);
		for (Map.Entry<String, String> u : authAppService.usernamesAndPasswords().entrySet()) {
			listUserDetails.add(new UserDetailsImpl(u.getValue(), u.getKey()));
			System.out.println(u.getKey());
			System.out.println(u.getValue());
		}
		for (UserDetails ud : listUserDetails) {
			System.out.println("user details:"+ud.getUsername());
			System.out.println("user details:"+ud.getPassword());
			if (ud.getUsername().equals(username)) {
				System.out.println("Password:"+ud.getPassword());
				return ud;
			}
		}
		return null;
	}

}
