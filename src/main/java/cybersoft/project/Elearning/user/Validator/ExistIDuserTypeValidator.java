package cybersoft.project.Elearning.user.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.user.Validation.ExistIDuserType;
import cybersoft.project.Elearning.user.service.UserTypeService;

public class ExistIDuserTypeValidator implements ConstraintValidator<ExistIDuserType, Long> {

	
	private String message;
	
	@Autowired
	private UserTypeService service;
	
	
	
	@Override
	public void initialize(ExistIDuserType constraintAnnotation) {
		// TODO Auto-generated method stub
		message=constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		
		boolean check=service.CheckIDUserType(value);
		if(check)
			return true;
		context.buildConstraintViolationWithTemplate(message).addConstraintViolation().disableDefaultConstraintViolation();
		
		return false;
	}

}
