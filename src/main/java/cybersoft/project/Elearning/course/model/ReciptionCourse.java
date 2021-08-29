package cybersoft.project.Elearning.course.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Reciption_Elearing")
public class ReciptionCourse extends AbstractEntity {
	
	private String username;
	
	private String nameCourse;
	
	
	
}
