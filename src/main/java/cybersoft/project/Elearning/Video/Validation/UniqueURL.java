package cybersoft.project.Elearning.Video.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.project.Elearning.Video.Validator.UniqueURLValidator;

@Constraint(validatedBy = UniqueURLValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueURL {

	String message() default "URL must not duplicate";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	
}
