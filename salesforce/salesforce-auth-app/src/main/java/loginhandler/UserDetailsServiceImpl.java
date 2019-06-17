package loginhandler;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	List<UserDetails> listUserDetails;
	
	UserDetailsServiceImpl(List<UserDetails> listUserDetails){
		this.listUserDetails = listUserDetails;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		for (UserDetails ud : listUserDetails) {
			if (ud.getUsername().equals(username)) {
				return ud;
			}
		}
		return null;
	}

	
}
