package cybersoft.project.Elearning.Review.Service;

import java.util.List;

import cybersoft.project.Elearning.Review.Dto.ReviewDto;
import cybersoft.project.Elearning.Review.model.Review;

public interface ReviewService {
		Review save(ReviewDto dto,String codeCourse);
		
		List<Review> findallReview();
}
