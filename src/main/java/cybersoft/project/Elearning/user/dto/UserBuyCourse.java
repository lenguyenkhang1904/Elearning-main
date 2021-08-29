package cybersoft.project.Elearning.user.dto;

import java.util.ArrayList;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.project.Elearning.course.Validation.ExistCodeCourse;
import cybersoft.project.Elearning.course.model.Course;
import cybersoft.project.Elearning.user.Validation.ExistUser;
import cybersoft.project.Elearning.user.Validation.ExitsCodeValidate;
import cybersoft.project.Elearning.user.Validation.UniqueCodeValidator;
import cybersoft.project.Elearning.user.Validation.UniqueEmail;
import cybersoft.project.Elearning.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBuyCourse {
	
	@NotBlank(message = "{Course.codeCourse.notblank}")
	@ExistCodeCourse
	private String codeCourse;
	
	@NotBlank(message = "{user.username.notblank}")
	@ExistUser
	private String username;
	
	@NotBlank(message = "{user.fullname.notblank}")
	@Size(min = 2,max =15,message = "{user.fullname.size}")
	private String fullname;
	
	@Email
	@NotBlank(message = "{user.email.notblank}")
	@Size(min = 4,max = 20,message = "{user.email.size}")
	private String email;
	
	@NotBlank(message="{Course.CodeValidator.notblank}")
	@ExitsCodeValidate
	@UniqueCodeValidator
	private String codeValidator;
	
	
}
