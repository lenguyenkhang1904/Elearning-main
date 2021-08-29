package cybersoft.project.Elearning.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cybersoft.project.Elearning.user.Validation.ExistIDuserType;
import cybersoft.project.Elearning.user.Validation.ExistUserType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserTypeUpdateDto {
	
	@NotBlank(message = "{usertype.nameUserType.notblank}")
	@Size(min = 2,max = 20,message = "{usertype.nameUserType.size}")
	@ExistUserType
	private String nameUserType;
	
	@NotNull(message = "Id hasnt to be Null")
	@ExistIDuserType
	private Long id;
	
}
