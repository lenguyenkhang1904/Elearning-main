package cybersoft.project.Elearning.course.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.Ultils.MapModelToDto;
import cybersoft.project.Elearning.course.Dto.CourseCategorydto;
import cybersoft.project.Elearning.course.Repository.CourseCategoryRepository;
import cybersoft.project.Elearning.course.model.CourseCategory;

@Service
public class CourseCategoryServiceImPL implements CourseCategoryService {

	@Autowired
	private CourseCategoryRepository courseCategoryRepository;
	@Autowired
	private MapModelToDto<Object, Object> mapper;
	
	
	
	@Override
	public List<CourseCategory> findall() {
		// TODO Auto-generated method stub
		return courseCategoryRepository.findAll();
	}

	@Override
	public CourseCategory save(CourseCategorydto dto) {
		// TODO Auto-generated method stub
		
		CourseCategory category=new CourseCategory();
		
		category=(CourseCategory) mapper.MapToDto(dto, category);
		
		return courseCategoryRepository.save(category);
	}

	public CourseCategory update(CourseCategorydto dto,Long id)
	{
		CourseCategory category=courseCategoryRepository.getOne(id);
		category=(CourseCategory)mapper.MapToDto(dto, category);
		
		
		return courseCategoryRepository.save(category);
	}

	@Override
	public boolean CheckExistCodeCateGory(String value) {
		// TODO Auto-generated method stub
		return courseCategoryRepository.countByCodeCategory(value)==1;
	}
	
	
}
