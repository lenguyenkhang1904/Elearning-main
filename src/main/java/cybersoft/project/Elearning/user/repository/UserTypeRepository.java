package cybersoft.project.Elearning.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.user.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
	int countByCodeUser(String usercode);
	
	//@Query("SELECT u.codeUser , u.nameUserType  FROM UserType u WHERE u.codeUser=:codeUser")
	Optional<UserType> findByCodeUser(String codeUser);
	
	int countById(Long id);
}
