package cybersoft.project.Elearning.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import cybersoft.project.Elearning.course.model.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="UserBought_Elearning")
public class UserBought extends AbstractEntity {
	
	private String codeCourse;
	
	private String username;
	
	private String codeValidator;
	
	private String codeUser;

	
	private String fullname;
	
	
	private String email;
	
	
	@ManyToMany(mappedBy = "learners",fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Course> courses=new HashSet<>();
	
}
