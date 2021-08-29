package cybersoft.project.Elearning.user.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.user.model.UserBought;

@Repository
public interface UserBoughtRepository extends JpaRepository<UserBought, Long> {
	
	
	@Query("SELECT u FROM UserBought u WHERE u.codeCourse=:codeUser")
	Set<UserBought> findAllLearners(@Param("codeCourse") String codeCourse);
}
