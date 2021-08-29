package cybersoft.project.Elearning.user.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.project.Elearning.user.Validator.ExistUserTypeValidator;

@Constraint(validatedBy = ExistUserTypeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistUserType {
			
		String  message() default "UserType is in Valid";
		
		Class<?>[] groups() default {};
		
		Class<? extends Payload>[] payload() default {};
		
	
}
