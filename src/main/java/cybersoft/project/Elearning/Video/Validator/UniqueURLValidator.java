package cybersoft.project.Elearning.Video.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.project.Elearning.Video.Service.VideoService;
import cybersoft.project.Elearning.Video.Validation.UniqueURL;

public class UniqueURLValidator implements ConstraintValidator<UniqueURL, String> {

	
	private String message;
	
	@Autowired
	private VideoService service;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		boolean checkDuplicate=service.checkDuplicateURL(value);
		
		if(!checkDuplicate)
			return true;
		context.buildConstraintViolationWithTemplate(message)
		.addConstraintViolation().disableDefaultConstraintViolation();
		
		
		return false;
	}
	
	@Override
	public void initialize(UniqueURL constraintAnnotation) {
		// TODO Auto-generated method stub
		this.message=constraintAnnotation.message();
	}
	

}
