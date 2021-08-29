package cybersoft.project.Elearning.security.Jwt;

import java.util.Date;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JWTUltils {

	private Logger logger=LoggerFactory.getLogger(JWTUltils.class);
	
	
	public String generateJWT(Authentication auth)
	{
		
		UserDetails userdetail=(UserDetails) auth.getPrincipal();
		
		Date now=new Date();
		
		return Jwts.builder()
				.setSubject(userdetail.getUsername())
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime()+90000000))
				.signWith(SignatureAlgorithm.HS512, "cybersoft-Elearning")
				.compact();
		
	}
	
	public boolean ValidationToken(String token)
	{
		try {
			
			Jwts.parser().setSigningKey("cybersoft-Elearning").parseClaimsJws(token);
			
			return true;
			
		}catch (ExpiredJwtException e) {
			logger.error("JWT Token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT Token is unsupported: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("JWT Token is invalid: {}", e.getMessage());
		} catch (SignatureException e) {
			logger.error("JWT Token has incorrect signature: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT Claims is empty: {}", e.getMessage());
		}
		
		return false;
	}

	public String getTokenFromRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		String header=request.getHeader("Authorization");
		
		if(header!=null && header.startsWith("Bearer "))
			return header.substring(7, header.length());
		
		return null;
		
	}

	public String getUsernameFromToken(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey("cybersoft-Elearning").parseClaimsJws(token).getBody().getSubject();
	}
	
}
