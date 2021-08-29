package cybersoft.project.Elearning.user.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.user.Validation.ExistUserType;
import cybersoft.project.Elearning.user.service.UserTypeService;

public class ExistUserTypeValidator implements ConstraintValidator<ExistUserType, String> {

	
	
	private String message;
	
	@Autowired
	private UserTypeService service;
	
	
	@Override
	public void initialize(ExistUserType constraintAnnotation) {
		// TODO Auto-generated method stub
		this.message=constraintAnnotation.message();
	}
	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		boolean checkExistUserType =service.CheckExistUserType(value);
		if(checkExistUserType)
			return true;
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation().disableDefaultConstraintViolation();
		
		return false;
	}

}
