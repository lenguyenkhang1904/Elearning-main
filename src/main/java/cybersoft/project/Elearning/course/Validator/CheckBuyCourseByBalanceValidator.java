package cybersoft.project.Elearning.course.Validator;

import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.course.Repository.CourseRepository;
import cybersoft.project.Elearning.course.Validation.CheckBuyCourseByBalance;
import cybersoft.project.Elearning.user.Validation.Checkbalance;

public class CheckBuyCourseByBalanceValidator implements ConstraintValidator<CheckBuyCourseByBalance, Object> {

	
	private String message;
	private String Balance;
	private String CodeCourse;
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Override
	public void initialize(CheckBuyCourseByBalance constraintAnnotation) {
		// TODO Auto-generated method stub
		this.message=constraintAnnotation.message();
		this.CodeCourse=constraintAnnotation.getCodeCourse();
		this.Balance=constraintAnnotation.getPrice();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		
		try {
			String codeCourse = (String)value.getClass().getMethod(CodeCourse).invoke(value);
			
			
			String balance=(String)value.getClass().getMethod(Balance).invoke(value);
			
			
			Double price=courseRepository.getBalance(codeCourse);
			Double balances=Double.parseDouble(balance);
			
			if(price<=balances)
				return true;
			context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation().disableDefaultConstraintViolation();
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}

}
