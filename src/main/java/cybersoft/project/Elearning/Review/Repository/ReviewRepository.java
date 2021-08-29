package cybersoft.project.Elearning.Review.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.Review.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	
	
	
	
}
