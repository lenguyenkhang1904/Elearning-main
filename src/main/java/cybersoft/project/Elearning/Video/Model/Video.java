package cybersoft.project.Elearning.Video.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.project.Elearning.CommonData.AbstractEntity;
import cybersoft.project.Elearning.course.model.Course;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Video_Elearning")
@Getter
@Setter
public class Video extends AbstractEntity {

	private String title;
	
	private String URL;
	
	private int time_count ;
	
	@OneToMany(mappedBy = "video")
	@JsonIgnore
	private Set<Course> course=new HashSet<>();
	
	
}
