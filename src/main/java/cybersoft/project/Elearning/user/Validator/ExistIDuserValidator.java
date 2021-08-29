package cybersoft.project.Elearning.user.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.user.Validation.ExistIdUser;
import cybersoft.project.Elearning.user.service.UserService;

public class ExistIDuserValidator implements ConstraintValidator<ExistIdUser, Long> {

	
	private String messgae;
	
	@Autowired
	private UserService service;
	
	
	
	@Override
	public void initialize(ExistIdUser constraintAnnotation) {
		// TODO Auto-generated method stub
		this.messgae=constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		boolean check=service.checkIdExits(value);
		
		if(check)
			return true;
		context.buildConstraintViolationWithTemplate(messgae).addConstraintViolation().disableDefaultConstraintViolation();
		
		return false;
	}

}
