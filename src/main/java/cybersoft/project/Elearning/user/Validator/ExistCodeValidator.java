package cybersoft.project.Elearning.user.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.course.Service.CourseService;
import cybersoft.project.Elearning.user.Validation.ExitsCodeValidate;
import cybersoft.project.Elearning.user.Validation.UniqueCodeValidator;

public class ExistCodeValidator  implements ConstraintValidator<ExitsCodeValidate,String> {
private String message;
	
	
	@Autowired
	private CourseService service;
	
	@Override
	public void initialize(ExitsCodeValidate constraintAnnotation) {
		// TODO Auto-generated method stub
		this.message=constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean check =service.checkExistCodeValidator(value);
		
		if (check) 
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation().disableDefaultConstraintViolation();
		return false;
	}

}
