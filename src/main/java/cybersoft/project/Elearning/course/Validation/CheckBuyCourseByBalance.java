package cybersoft.project.Elearning.course.Validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.project.Elearning.course.Validator.CheckBuyCourseByBalanceValidator;
@Constraint(validatedBy = CheckBuyCourseByBalanceValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckBuyCourseByBalance {
	
	String getPrice() default "getPrice" ;
	
	String getCodeCourse() default "getCodeCourse" ;
	
	String  message() default "Your Balance is not enough to buy";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
