package cybersoft.project.Elearning.user.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.user.Validation.UniqueUsername;
import cybersoft.project.Elearning.user.repository.UserRepository;
import cybersoft.project.Elearning.user.service.UserService;
import io.swagger.annotations.Authorization;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	
	private String messages;
	
	@Autowired
	private UserService service;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		boolean user=service.checkDuplicateUsername(value);
		if(!user)
			return true;
		context.buildConstraintViolationWithTemplate(messages)
		.addConstraintViolation().disableDefaultConstraintViolation();
		
		return false;
	}
	
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		// TODO Auto-generated method stub
		this.messages=constraintAnnotation.message();
	}

}
