package cybersoft.project.Elearning.user.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.project.Elearning.user.Validator.ExistCodeValidator;
import cybersoft.project.Elearning.user.Validator.UniqueCodeValidatorValidation;

@Constraint(validatedBy =ExistCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExitsCodeValidate {
String  message() default "Code must be existed";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
