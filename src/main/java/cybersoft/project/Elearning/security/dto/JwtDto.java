package cybersoft.project.Elearning.security.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtDto {
	private String jwtCode;
	
	public JwtDto getJWTcode(String jwtCode)
	{
		this.jwtCode=jwtCode;
		return this;
	}
}
