package cybersoft.project.Elearning.course.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.course.Service.CourseService;
import cybersoft.project.Elearning.course.Validation.ExistCodeCourse;

public class ExistCodeCourseValidator implements ConstraintValidator<ExistCodeCourse, String> {

	
	private String message;
	
	@Autowired 
	private CourseService courseService;
	@Override
	public void initialize(ExistCodeCourse constraintAnnotation) {
		// TODO Auto-generated method stub
		this.message=constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		
		boolean check =courseService.checkDuplicateCodeCourse(value);
		
		if(check)
			return true;
		context.buildConstraintViolationWithTemplate(message).addConstraintViolation().disableDefaultConstraintViolation();
		
		
		
		return false;
	}

}
