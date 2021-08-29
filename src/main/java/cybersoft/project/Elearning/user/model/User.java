package cybersoft.project.Elearning.user.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonIgnore;


import cybersoft.project.Elearning.CommonData.AbstractEntity;
import cybersoft.project.Elearning.course.model.Course;
import cybersoft.project.Elearning.role.model.Role;
import cybersoft.project.Elearning.role.model.RoleGroup;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User_ELearning")
@Getter
@Setter
public class User extends AbstractEntity {
	

		@NotBlank(message = "username cant be blank")
		@Size(min = 1,max = 50,message = "username must be between ${min} to ${max} ")
		@Column(unique = true)
		private String username;
		
		@Email
		@Column(unique = true)
		private String email;
		
		@NotBlank
		private String password;
		
		@NotBlank
		private String fullname;
		
		
		
		private Double balance;
		
		 
		@ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
		@JsonIgnore
		private Set<RoleGroup> roles=new HashSet<>();
		
		
		
		@ManyToOne(fetch = FetchType.EAGER)
		@NotNull
		private UserType userType;
		
		
		@ManyToMany(mappedBy = "creators",fetch = FetchType.EAGER)
		@JsonIgnore
		private Set<Course> course=new HashSet<>();
		
		
		/*
		 * @ManyToMany(mappedBy = "learners",fetch = FetchType.EAGER)
		 * 
		 * @JsonIgnore private Set<Course> courseLeaner=new HashSet<>();
		 */
		
		
		
		
		public User username(String username)
		{
			this.username=username;
			return this;
		}
		
		public User password(String password)
		{
			this.password=password;
			return this;
		}
		
		public User fullname(String fullname)
		{
			this.fullname=fullname;
			return this;
		}
		
		public User email(String email)
		{
			this.email=email;
			return this;
		}
		
		
		
}
