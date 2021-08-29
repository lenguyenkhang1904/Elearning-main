package cybersoft.project.Elearning.user.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import cybersoft.project.Elearning.user.Validation.Checkbalance;
import cybersoft.project.Elearning.user.Validation.Confirmpassword;
import cybersoft.project.Elearning.user.Validation.ExistUserType;
import cybersoft.project.Elearning.user.Validation.StrongPassword;
import cybersoft.project.Elearning.user.Validation.UniqueEmail;
import cybersoft.project.Elearning.user.Validation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto {

	
	
	@NotBlank(message ="{user.username.notblank}")
	@Size(min = 1,max = 50,message = "{user.username.size}")
	@UniqueUsername
	private String username;
	
	@Email
	@UniqueEmail
	@NotBlank(message = "{user.email.notblank}")
	@Size(min = 4,max = 20,message = "{user.email.size}")
	private String email;
	
	@NotBlank(message = "{user.password.notblank}")
	@Size(min = 8,max = 50,message = "{password must be between {min} to {max}}")
	private String password;
	
	@NotBlank(message = "{user.fullname.notblank}")
	@Size(min = 2,max =15,message = "{user.fullname.size}")
	private String fullname;
	
	@NotBlank(message = "{user.confirmpassword.notblank}")
	@Size(min = 2,max =50,message = "{user.confirmpassword.size}")
	//@StrongPassword
	//@Pattern(regexp = )
	private String confirmpassword;
	
	@NotBlank(message = "{usertype.codeUser.notblank}")
	@ExistUserType
	private String CodeUser;
	
	
	@Checkbalance
	@NotNull(message = "{user.price.notNULL}")
	private Double balance;
	
}
