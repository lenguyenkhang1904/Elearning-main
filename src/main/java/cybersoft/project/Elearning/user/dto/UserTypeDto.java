package cybersoft.project.Elearning.user.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTypeDto {
	
	@NotBlank(message = "{usertype.codeUser.notblank}")
	@Size(min = 2,max = 5,message = "{usertype.codeUser.size}")
	private String codeUser;
	
	
	@NotBlank(message = "{usertype.nameUserType.notblank}")
	@Size(min = 2,max = 50,message = "{usertype.nameUserType.size}")
	private String nameUserType;
}
