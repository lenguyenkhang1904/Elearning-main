package cybersoft.project.Elearning.course.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.course.Service.CourseCategoryService;
import cybersoft.project.Elearning.course.Service.CourseService;
import cybersoft.project.Elearning.course.Validation.ExistCodeCateGory;
import cybersoft.project.Elearning.course.Validation.UniqueCodeCourse;

public class UniqueCodeCourseValidator implements ConstraintValidator<UniqueCodeCourse, String> {
	
	private String message;
	@Autowired
	private CourseService service;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean checkExistCode=service.checkDuplicateCodeCourse(value);
		if(checkExistCode)
			return true;
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation().disableDefaultConstraintViolation();
		return false;
	}
	
	@Override
	public void initialize(UniqueCodeCourse constraintAnnotation) {
		// TODO Auto-generated method stub
		this.message=constraintAnnotation.message();
	}
	
}
