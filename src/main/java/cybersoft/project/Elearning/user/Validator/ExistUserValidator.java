package cybersoft.project.Elearning.user.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.user.Validation.ExistUser;
import cybersoft.project.Elearning.user.service.UserService;

public class ExistUserValidator implements ConstraintValidator<ExistUser,String > {

	

	private String message;
	@Autowired
	private UserService service;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		boolean checkExist=service.CheckExits(value);
		
		if(checkExist)  
			return true;
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation().disableDefaultConstraintViolation();
		return false;
	}


	

}
