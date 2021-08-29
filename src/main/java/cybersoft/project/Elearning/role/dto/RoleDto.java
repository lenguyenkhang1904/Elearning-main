package cybersoft.project.Elearning.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.project.Elearning.user.Validation.Checkbalance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
	
	@NotBlank(message = "{role.name.notblank}")
	@Size(min = 1,max = 50,message = "{role.name.size}")
	private String name;
	
	@NotBlank(message = "{role.description.notblank}")
	@Size(min = 1,max = 50,message = "{role.desciription.size}")
	private String description;
	
	
}
