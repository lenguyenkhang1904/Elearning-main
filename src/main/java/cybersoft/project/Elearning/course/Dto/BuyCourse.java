package cybersoft.project.Elearning.course.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cybersoft.project.Elearning.course.Validation.CheckBuyCourseByBalance;
import cybersoft.project.Elearning.course.Validation.ExistCodeCourse;
import cybersoft.project.Elearning.user.Validation.ExistIdUser;
import cybersoft.project.Elearning.user.Validation.ExistUser;
import cybersoft.project.Elearning.user.Validation.UniqueUsername;
import cybersoft.project.Elearning.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyCourse {
	
	@NotBlank()
	@ExistUser
	private String username;
	
	@NotBlank()
	@ExistCodeCourse
	private String codeCourse;
	
	
	@NotNull
	private Long idCourseForValidatorCode;
	
	@ExistIdUser
	private Long idUser;
	
	
	
	private Double price;
	
}
