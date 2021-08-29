package cybersoft.project.Elearning.user.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.user.Validation.UniqueEmail;
import cybersoft.project.Elearning.user.repository.UserRepository;
import cybersoft.project.Elearning.user.service.UserService;



public class EmailValidator implements ConstraintValidator<UniqueEmail, String> {

	
	private String message;
	
	@Autowired
	private UserService service;
	
	
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		this.message=constraintAnnotation.message();
	}
	
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
			boolean checkDuplicateEmail=service.checkDuplicateEmail(value);
			
			if(!checkDuplicateEmail)
				return true;
			
			context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation().disableDefaultConstraintViolation();
		
		return false;
	}

}
