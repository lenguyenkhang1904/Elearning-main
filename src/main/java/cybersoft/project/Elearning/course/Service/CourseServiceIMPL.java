package cybersoft.project.Elearning.course.Service;

import java.util.Arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.Ultils.MapModelToDto;
import cybersoft.project.Elearning.Video.Repository.VideoRepository;
import cybersoft.project.Elearning.course.Dto.BuyCourse;
import cybersoft.project.Elearning.course.Dto.CourseDto;
import cybersoft.project.Elearning.course.Dto.CourseUpdateDto;
import cybersoft.project.Elearning.course.Repository.CourseCategoryRepository;
import cybersoft.project.Elearning.course.Repository.CourseRepository;
import cybersoft.project.Elearning.course.Repository.ReciptionCourseRepository;
import cybersoft.project.Elearning.course.model.Course;
import cybersoft.project.Elearning.course.model.CourseCategory;
import cybersoft.project.Elearning.course.model.ReciptionCourse;
import cybersoft.project.Elearning.user.model.User;
import cybersoft.project.Elearning.user.model.UserBought;
import cybersoft.project.Elearning.user.repository.UserBoughtRepository;
import cybersoft.project.Elearning.user.repository.UserRepository;

@Service
public class CourseServiceIMPL implements CourseService {

	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private MapModelToDto<Object, Object> mapper;
	
	@Autowired
	private CourseCategoryRepository categoryRepository; 
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReciptionCourseRepository reciptionCourseRepository;
	@Autowired
	private UserBoughtRepository boughtRepository;
	
	@Override
	public List<Course> findall() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}
	
	
	
	
	@Override
	public Course save(CourseDto dto) {
		// TODO Auto-generated method stub
		
		Course course=new Course();
		course=(Course) mapper.MapToDto(dto, course);
		
	
		
		Optional<CourseCategory> category=categoryRepository.findByCodeCategory(dto.getCodeCateGory());
		
		if(!category.isEmpty())
			course.setCourseCategory(category.get());
		
		Optional<User> creator=userRepository.findByUsername(dto.getUsernameCreator());
		
		if(!creator.isEmpty())
			course.addUser(creator.get());
		
		
		Set<UserBought> learnersBoughts=boughtRepository.findAllLearners(dto.getCodeCourse());
		
		if(!learnersBoughts.isEmpty())
			course.setLearners(learnersBoughts);
		
		
		
		
		return courseRepository.save(course);
	}

	public Course updateCourse(CourseUpdateDto dto)
	{
		Course course= courseRepository.getOne(dto.getId());
		
		course=(Course)mapper.MapToDto(dto, course);
		
		
		return course;
		
	}
	
	public void deleteCourse(Long idCourse)
	{
		courseRepository.deleteById(idCourse);
	}





	@Override
	public boolean checkDuplicateCodeCourse(String codeCourse) {
		// TODO Auto-generated method stub
		return courseRepository.countByCodeCourse(codeCourse)>=1;
	}

	
	public ReciptionCourse MapUserBuyCoursetoAll(BuyCourse buyCourse)
	{
		ReciptionCourse reciptionCourse=new ReciptionCourse();
		
			Optional<User> username=userRepository.findByUsername(buyCourse.getUsername());
			
			if(!username.isEmpty())
				reciptionCourse.setUsername(username.get().getUsername());
			
			Optional<Course> course=courseRepository.findByCodeCourse(buyCourse.getCodeCourse());
			
			if(!course.isEmpty())
				reciptionCourse.setNameCourse(course.get().getCodeCourse());
			
			Double balanceUpdate=userRepository.getBalance(buyCourse.getUsername());
			
			
			balanceUpdate=balanceUpdate-buyCourse.getPrice();
			
			if(balanceUpdate>0)
			{
				User user=userRepository.getOne(buyCourse.getIdUser());
				
					user.setBalance(balanceUpdate);
				
				userRepository.save(user);
			}
			
			return reciptionCourseRepository.save(reciptionCourse);
	}
	
	public List<ReciptionCourse> ListofReciption()
	{
		return reciptionCourseRepository.findAll();
	}




	@Override
	public void SaveCodeValidation(Long id, String code) {
		// TODO Auto-generated method stub
		
		Course course=courseRepository.getOne(id);
		
		course.setCodeValidator(code);
		
		 courseRepository.save(course);
			
	}




	@Override
	public boolean checkUniqueCodeValidator(String codeCourse) {
		// TODO Auto-generated method stub
		return courseRepository.countByCodeValidator(codeCourse)>=1;
	}




	@Override
	public boolean checkExistCodeValidator(String codeCourse) {
		// TODO Auto-generated method stub
		return courseRepository.countByCodeValidator(codeCourse)==1;
	}









}
