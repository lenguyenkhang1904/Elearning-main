package cybersoft.project.Elearning.course.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
		Optional<Course> findByCodeCourse(String value);
		
		void deleteBycodeCourse(String codeCourse);
		
		int countByCodeCourse(String code);
		
		int countByCodeValidator(String code);
		
		
		@Query("SELECT c.price FROM  Course c WHERE c.codeCourse=:codeCourse")
		Double getBalance(@Param("codeCourse") String codeCourse);
		
		
		
}
