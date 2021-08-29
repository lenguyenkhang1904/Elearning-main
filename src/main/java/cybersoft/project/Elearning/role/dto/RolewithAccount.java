package cybersoft.project.Elearning.role.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import cybersoft.project.Elearning.role.model.Accounts;
import cybersoft.project.Elearning.role.model.Role;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RolewithAccount {
		
	private String fullname;
	private String username;
	
	
	
	private long idRole;
	

	private Set<Accounts> accounts;
	
}
