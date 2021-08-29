package cybersoft.project.Elearning.Review.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import cybersoft.project.Elearning.Ultils.Star;
import cybersoft.project.Elearning.course.model.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Review_Course_Elearning")
public class Review extends AbstractEntity {

	private Star star;
	
	private String feedback;
	
	@ManyToOne(fetch =FetchType.EAGER )
	private Course course;
	
	
	
}
