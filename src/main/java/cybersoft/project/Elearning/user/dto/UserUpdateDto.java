package cybersoft.project.Elearning.user.dto;


import javax.validation.constraints.Size;

import cybersoft.project.Elearning.user.Validation.Checkbalance;
import cybersoft.project.Elearning.user.Validation.ExistIdUser;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
	@NotBlank(message = "{user.password.notblank}")
	@Size(min = 8,max = 15,message = "{password must be between {min} to {max}}")
	private String password;
	
	@NotBlank(message = "{user.fullname.notblank}")
	@Size(min = 2,max =15,message = "{user.fullname.size}")
	private String fullname;
	
	@NotBlank(message = "{user.confirmpassword.notblank}")
	@Size(min = 2,max =15,message = "{user.confirmpassword.size}")
	private String confirmpassword;
	
	@NotNull
	@ExistIdUser
	private Long id;
	
	@Checkbalance
	private Double balance;
	
}
