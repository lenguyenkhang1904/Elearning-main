package cybersoft.project.Elearning.user.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.project.Elearning.user.Validator.ConfirmpasswordValidator;

@Constraint(validatedBy = ConfirmpasswordValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Confirmpassword {
	String getPassword() default "getPassword";
	
	String getConfirmpassword() default "getConfirmpassword";

	String message() default "confirmpassword and password are not asame";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};  
	
	
	
}
