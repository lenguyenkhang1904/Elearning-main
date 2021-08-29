package cybersoft.project.Elearning.security.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

	@NotBlank(message = "{LoginDto.username.notblank}")
	private String username;
	
	@NotBlank(message = "{LoginDto.password.notblank}")
	private String password;
}
