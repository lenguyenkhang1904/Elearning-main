package cybersoft.project.Elearning.course.Service;

import java.util.List;

import cybersoft.project.Elearning.course.Dto.CourseCategorydto;
import cybersoft.project.Elearning.course.model.CourseCategory;

public interface CourseCategoryService {
	List<CourseCategory> findall();
	
	CourseCategory save(CourseCategorydto dto);

	boolean CheckExistCodeCateGory(String value);
}
