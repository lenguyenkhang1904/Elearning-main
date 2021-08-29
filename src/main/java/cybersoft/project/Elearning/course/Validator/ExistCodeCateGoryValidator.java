package cybersoft.project.Elearning.course.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.course.Service.CourseCategoryService;
import cybersoft.project.Elearning.course.Validation.ExistCodeCateGory;
import cybersoft.project.Elearning.user.service.UserService;

public class ExistCodeCateGoryValidator implements ConstraintValidator<ExistCodeCateGory, String> {

	
	
	@Autowired
	private String message;
	@Autowired
	private CourseCategoryService service;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean checkExistCode=service.CheckExistCodeCateGory(value);
		
		if(checkExistCode)
			return true;
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation().disableDefaultConstraintViolation();
		return false;
	}
	
	@Override
	public void initialize(ExistCodeCateGory constraintAnnotation) {
		// TODO Auto-generated method stub
		this.message=constraintAnnotation.message();
	}
	
	
}
