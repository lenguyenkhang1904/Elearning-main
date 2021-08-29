package cybersoft.project.Elearning.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import cybersoft.project.Elearning.CommonData.ResponseObject;
import cybersoft.project.Elearning.security.Jwt.JWTUltils;
import cybersoft.project.Elearning.security.dto.JwtDto;
import cybersoft.project.Elearning.security.dto.LoginDto;

@RestController
@RequestMapping("/authentication")
public class AutheticationController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTUltils ultils;
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@Valid @RequestBody LoginDto dto)
	{
		
		Authentication authentication=null;
		
		try {
			
			authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),dto.getPassword()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			String token=ultils.generateJWT(authentication);
			
			return new ResponseEntity<>(new ResponseObject(new JwtDto().getJWTcode(token)),HttpStatus.OK);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return new ResponseEntity<>(new ResponseObject("there is no data"),HttpStatus.BAD_REQUEST);
	}
	
}
