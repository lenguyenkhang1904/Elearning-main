package cybersoft.project.Elearning.course.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.project.Elearning.course.Validator.ExistCodeCourseValidator;
import cybersoft.project.Elearning.course.Validator.UniqueCodeCourseValidator;

@Constraint(validatedBy = ExistCodeCourseValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCodeCourse {
	String  message() default "CodeCourse is Duplicate";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
