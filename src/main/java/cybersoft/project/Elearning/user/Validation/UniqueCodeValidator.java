package cybersoft.project.Elearning.user.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.project.Elearning.user.Validator.UniqueCodeValidatorValidation;

@Constraint(validatedBy = UniqueCodeValidatorValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCodeValidator {
	
	String  message() default "Code must be Unique";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
