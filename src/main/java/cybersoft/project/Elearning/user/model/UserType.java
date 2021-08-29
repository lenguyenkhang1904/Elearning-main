package cybersoft.project.Elearning.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User_Type")
@Getter
@Setter
public class UserType extends AbstractEntity {
		
		
		
		private String codeUser;
		
		
		private String nameUserType;
		
		@OneToMany(mappedBy = "userType")
		@JsonIgnore
		private Set<User> users=new HashSet<>();
		
		
		public UserType getCodeUser(String code)
		{
			this.codeUser=code;
			return this;
		}
		
		public UserType getUserType(String code)
		{
			this.nameUserType=code;
			return this;
		}
		
}
