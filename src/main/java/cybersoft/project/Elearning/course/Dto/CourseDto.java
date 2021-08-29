package cybersoft.project.Elearning.course.Dto;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;


import cybersoft.project.Elearning.course.Validation.UniqueCodeCourse;
import cybersoft.project.Elearning.user.Validation.ExistUser;
import cybersoft.project.Elearning.user.Validation.ExistUserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
	
	//@UniqueCodeCourse
	@NotBlank(message = "{Course.codeCourse.notblank}")
	@Size(min = 1,max=8,message = "{Course.codeCourse.size}")
	private String codeCourse;
	

	@NotBlank(message = "{Course.aliasCourse.notblank}")
	@Size(min = 1,max=20,message = "{Course.aliasCourse.size}")
	private String aliasCourse;
	
	@NotBlank(message = "{Course.description.notblank}")
	@Size(min = 1,max=20,message = "{Course.description.size}")
	private String description;
	
	private int view;
	
	@NotBlank(message = "{Course.display.notblank}")
	@Size(min = 1,max=20,message = "{Course.display.size}")
	private String display;
	
	@ExistUser
	private String usernameCreator;

	
	private String CodeCateGory;
	
	private int noOfLearner;
	
	
	private double price;
	
	
	private int discount;
	
	
	private int hour_count;
}
