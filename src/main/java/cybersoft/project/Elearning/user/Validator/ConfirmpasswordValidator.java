package cybersoft.project.Elearning.user.Validator;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.project.Elearning.user.Validation.Confirmpassword;

public class ConfirmpasswordValidator implements ConstraintValidator<Confirmpassword, Object> {

	
	private String messages;
	private String getPassword;
	private String getConfirmpassword;
	
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		try {
			String password=(String) value.getClass().getMethod(getPassword).invoke(value);
			
			String confirmpassword =(String) value.getClass().getMethod(getConfirmpassword).invoke(value);
			if(password.equals(confirmpassword))
				return true;
			context.buildConstraintViolationWithTemplate(messages)
				.addConstraintViolation().disableDefaultConstraintViolation();
			
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}
	
	@Override
	public void initialize(Confirmpassword constraintAnnotation) {
		// TODO Auto-generated method stub
		this.messages=constraintAnnotation.message();
		this.getPassword=constraintAnnotation.getPassword();
		this.getConfirmpassword=constraintAnnotation.getConfirmpassword();
	}

}
