package cybersoft.project.Elearning.security.Jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import springfox.documentation.spi.service.contexts.SecurityContext;
@Component
public class AuthnenticationFilter extends OncePerRequestFilter {

	
	@Autowired
	private JWTUltils ultils;
	
	@Autowired
	private UserDetailsService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			
			String token=ultils.getTokenFromRequest(request);
			
			
			if(token!=null)
			{
				String username=ultils.getUsernameFromToken(token);
				
				UserDetails userdetails=service.loadUserByUsername(username);
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
						new UsernamePasswordAuthenticationToken(userdetails.getUsername(),null,userdetails.getAuthorities());
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		filterChain.doFilter(request, response);
		
		
		
	}



}
