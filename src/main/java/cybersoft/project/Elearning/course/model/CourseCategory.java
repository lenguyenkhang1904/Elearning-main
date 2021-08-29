package cybersoft.project.Elearning.course.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CourseCategory")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class CourseCategory extends AbstractEntity {
	
	
	
		private String codeCategory;
		
		private String nameCateGory;
		
		@OneToMany(mappedBy ="courseCategory")
		@JsonIgnore
		private Set<Course> courses=new HashSet<>();
		
		
}
