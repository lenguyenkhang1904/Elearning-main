package cybersoft.project.Elearning.course.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseCategorydto {

	@NotBlank(message = "{CourseCateGory.nameCourseCateGory.notblank}")
	@Size(min = 1,max=5,message = "{CourseCateGory.codeCourseCateGory.size}")
	private String codeCategory;
	
	@NotBlank(message = "{CourseCateGory.nameCourseCateGory.notblank}")
	@Size(min = 1,max=5,message = "{CourseCateGory.nameCourseCateGory.size}")
	private String nameCateGory;
}
