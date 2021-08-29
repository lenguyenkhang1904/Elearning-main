package cybersoft.project.Elearning.course.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.project.Elearning.user.Validation.ExistUser;
import cybersoft.project.Elearning.user.Validation.ExistUserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseUpdateDto {
	@NotBlank(message = "{Course.description.notblank}")
	@Size(min = 1,max=20,message = "{Course.description.size}")
	private String description;
	
	private int view;
	
	@NotBlank(message = "{Course.display.notblank}")
	@Size(min = 1,max=20,message = "{Course.display.size}")
	private String display;

	@ExistUser
	private String usernameCreator;

	@ExistUserType
	private String CodeLearner;
	
	private String CodeCateGory;
	
	private int noOfLearner;
	
	
	private double price;
	
	
	private int discount;
	
	
	private int hour_count;
	
	private Long id;
}
