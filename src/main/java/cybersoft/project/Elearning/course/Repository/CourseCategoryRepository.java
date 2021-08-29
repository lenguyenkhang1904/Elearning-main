package cybersoft.project.Elearning.course.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.course.model.CourseCategory;

@Repository
public interface CourseCategoryRepository extends JpaRepository<CourseCategory, Long> {
			Optional<CourseCategory> findByCodeCategory(String code);
			
			int countByCodeCategory(String codeCateGory);
			
			
}
