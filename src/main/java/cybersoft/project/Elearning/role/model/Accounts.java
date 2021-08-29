package cybersoft.project.Elearning.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "acccount_Elearning")
public class Accounts  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String fullname;
	private String username;
	
	
	@Column(name = "Role_id",insertable  =false,updatable =false)
	private Long idRole;
	
	@ManyToOne
	@JoinColumn(name="Role_id")//chỉ tên cột khóa ngoại
	private Role role;
	
	
	public Accounts nameAccount(String fullname)
	{
		this.fullname=fullname;
		return this;
	}
	
	public Accounts usernameAccount(String username)
	{
		this.username=username;
		return this;
	}
	
	
	public Accounts idRole(Long id)
	{
		this.id=id;
		return this;
	}
	
	
	
	
}
