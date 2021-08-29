package cybersoft.project.Elearning.course.Service;

import java.util.List;


import java.util.Optional;

import cybersoft.project.Elearning.course.Dto.BuyCourse;
import cybersoft.project.Elearning.course.Dto.CourseCategorydto;
import cybersoft.project.Elearning.course.Dto.CourseDto;
import cybersoft.project.Elearning.course.Dto.CourseUpdateDto;
import cybersoft.project.Elearning.course.model.Course;
import cybersoft.project.Elearning.course.model.CourseCategory;
import cybersoft.project.Elearning.course.model.ReciptionCourse;

public interface CourseService {
	
	List<Course> findall();
	
	
	Course save(CourseDto dto);
	
	
	Course updateCourse(CourseUpdateDto dto);
	
	boolean checkDuplicateCodeCourse(String codeCourse);
	
	 void deleteCourse(Long id);
	 
	 ReciptionCourse MapUserBuyCoursetoAll(BuyCourse buyCourse);
	 
	 List<ReciptionCourse> ListofReciption();
	 
	 boolean checkUniqueCodeValidator(String codeCourse);
	 
	 boolean checkExistCodeValidator(String codeCourse);
	 
	 void SaveCodeValidation(Long idCourse,String code);
	 
}
