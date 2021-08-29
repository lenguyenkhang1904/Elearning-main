package cybersoft.project.Elearning.course.Dto;

import java.util.HashSet;
import java.util.Set;

import cybersoft.project.Elearning.user.model.UserBought;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseWithUser {
		
		private String description;
		
		private String codeCourse;
		
		private String username;
		
		private Set<UserBought> userBought=new HashSet<>();
}
