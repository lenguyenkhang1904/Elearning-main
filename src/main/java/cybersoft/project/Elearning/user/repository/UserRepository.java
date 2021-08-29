package cybersoft.project.Elearning.user.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.user.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	int countByUsername(String username);
	
	int countByEmail(String email);

	Optional<User> findByUsername(String value);
	
	
	@Query("SELECT u FROM User u WHERE u.userType.codeUser=:codeUser")
	Set<User> findByUserType(@Param("codeUser") String codeUser);
	
	@Query("SELECT c.balance FROM  User c WHERE c.username=:username")
	Double getBalance(@Param("username") String username);
	
	
	@Query("SELECT c.balance FROM  User c WHERE c.id=:id")
	Double UpdateBalance(@Param("id") Long id);
	
	int countById(Long id);
	
	
	
	
	
}
