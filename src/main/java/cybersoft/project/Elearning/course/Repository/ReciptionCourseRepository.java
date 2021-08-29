package cybersoft.project.Elearning.course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.course.model.ReciptionCourse;

@Repository
public interface ReciptionCourseRepository extends JpaRepository<ReciptionCourse, Long> {

}
