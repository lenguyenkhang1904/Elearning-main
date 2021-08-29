package cybersoft.project.Elearning.course.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.project.Elearning.course.Validator.ExistCodeCateGoryValidator;

@Constraint(validatedBy = ExistCodeCateGoryValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCodeCateGory {
	String  message() default "CodeCateGory is in Valid";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
