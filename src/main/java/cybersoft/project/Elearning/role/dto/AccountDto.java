package cybersoft.project.Elearning.role.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cybersoft.project.Elearning.role.model.Role;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AccountDto {
	
	
	
	private String fullname;
	private String username;
	
	
	
	private Long idRole;
	

}
