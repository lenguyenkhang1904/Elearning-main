package cybersoft.project.Elearning.user.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.project.Elearning.user.Validation.UniqueEmail;
import cybersoft.project.Elearning.user.Validation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAccepted {
		
	@NotBlank(message ="{user.username.notblank}")
	@Size(min = 1,max = 50,message = "{user.username.size}")
	@UniqueUsername
	private String username;
	
	@Email
	@UniqueEmail
	@NotBlank(message = "{user.email.notblank}")
	@Size(min = 4,max = 20,message = "{user.email.size}")
	private String email;
	
	
	
	@NotBlank(message = "{user.fullname.notblank}")
	@Size(min = 2,max =15,message = "{user.fullname.size}")
	private String fullname;
	
	private String codeCourse;
}
