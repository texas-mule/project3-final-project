package loginhandler;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5269649873490596646L;

	@Override
	public String getAuthority() {
		return "USER";
	}

}
