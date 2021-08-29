package cybersoft.project.Elearning.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import cybersoft.project.Elearning.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RoleGroup_Elearning")
@Getter
@Setter
public class RoleGroup extends AbstractEntity {

	private String groupname;
	
	private String description;
	
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "RoleGroup_Role",joinColumns = @JoinColumn(name = "id_roleGroup"),inverseJoinColumns = @JoinColumn(name = "id_Role"))
	private Set<Role> roles=new HashSet<>();
	
	
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name = "User_Role_Elearning",joinColumns = @JoinColumn(name="id_RoleGroup"),inverseJoinColumns = @JoinColumn(name="id_User"))
	private Set<User> users=new HashSet<>();
	
	
	public RoleGroup addRole(Role role)
	{
		this.roles.add(role);
		role.getGroups().add(this);
		return this;
	}
}
