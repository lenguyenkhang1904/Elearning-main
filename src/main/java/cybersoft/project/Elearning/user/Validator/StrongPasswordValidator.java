package cybersoft.project.Elearning.user.Validator;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.project.Elearning.user.Validation.StrongPassword;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {

	
	private String message;
	
	
	
	
	@Override
	public void initialize(StrongPassword constraintAnnotation) {
		// TODO Auto-generated method stub
		this.message=constraintAnnotation.message();
		
	}
	

	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		
			
			if(value.startsWith("Cybersoft")  )
					return true;
					
			context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation().disableDefaultConstraintViolation();
					

		
		
		return false;
	}

}
