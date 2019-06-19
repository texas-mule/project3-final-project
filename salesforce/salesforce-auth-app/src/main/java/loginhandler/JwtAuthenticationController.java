package loginhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@PostMapping("/authenticate")
	public String createAuthenticationToken(@RequestHeader("username") String username,
			@RequestHeader("password") String password) throws Exception {
		System.out.println("creating authentication token line 28");
		authenticate(username, password);
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		return jwtTokenUtil.generateToken(userDetails);
	}

	private void authenticate(String username, String password) throws Exception {
		System.out.println("authenticating line 35");
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
}
