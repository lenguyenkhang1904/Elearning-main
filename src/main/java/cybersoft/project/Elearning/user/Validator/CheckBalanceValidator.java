package cybersoft.project.Elearning.user.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.project.Elearning.user.Validation.Checkbalance;
import cybersoft.project.Elearning.user.model.User;

public class CheckBalanceValidator implements ConstraintValidator<Checkbalance, Double> {
		
	private String message;
	
	

	@Override
	public void initialize(Checkbalance constraintAnnotation) {
		this.message=constraintAnnotation.message();
		
	}
	
	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if(value>=50)
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation().disableDefaultConstraintViolation();
		
		
		return false;
	}
	
	
	
}
