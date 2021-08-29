package cybersoft.project.Elearning.Ultils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.ObjectError;

public class Errorutils {
	public static List<String> getMessage(List<ObjectError> errors)
	{
		List<String> messages=new LinkedList<>();
		
		for (ObjectError error : errors) {
		   messages.add(error.getDefaultMessage());
		}
		
		return messages;
	}
	
}
