package cybersoft.project.Elearning.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


import cybersoft.project.Elearning.CommonData.AbstractEntity;
import cybersoft.project.Elearning.user.model.User;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "Role_Elearning")
public class Role extends AbstractEntity {

	
	private String name;
	
	
	private String description;
	
	
	@OneToMany(mappedBy = "role",fetch= FetchType.LAZY)
	@JsonIgnore
	private Set<Accounts> accounts=new HashSet<>();
	
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Set<RoleGroup> groups=new HashSet<>();
	
	
	
	
	
	
	public Role roleName(String name)
	{
		this.name=name;
		return this;
	}
	
	public Role roleDescription(String description)
	{
		this.description=description;
		return this;
	}
	
	
}
