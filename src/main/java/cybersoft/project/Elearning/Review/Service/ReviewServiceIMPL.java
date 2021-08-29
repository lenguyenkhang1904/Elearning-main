package cybersoft.project.Elearning.Review.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.Review.Dto.ReviewDto;
import cybersoft.project.Elearning.Review.Repository.ReviewRepository;
import cybersoft.project.Elearning.Review.model.Review;
import cybersoft.project.Elearning.Ultils.MapModelToDto;
import cybersoft.project.Elearning.course.Repository.CourseRepository;
import cybersoft.project.Elearning.course.model.Course;

@Service
public class ReviewServiceIMPL implements ReviewService {

	@Autowired
	private ReviewRepository repository;
	@Autowired
	private MapModelToDto<Object, Object> mapper;
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Review save(ReviewDto dto,String codeCourse) {
		// TODO Auto-generated method stub
		
		Review review=new Review();
		
		review=(Review)mapper.MapToDto(dto, review);
		
		Optional<Course> course=courseRepository.findByCodeCourse(codeCourse);
		
		if(!course.isEmpty())
			review.setCourse(course.get());
		
		
		
		return repository.save(review);
	}

	@Override
	public List<Review> findallReview() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
}
