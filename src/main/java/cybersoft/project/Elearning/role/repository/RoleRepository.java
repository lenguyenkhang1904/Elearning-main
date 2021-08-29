package cybersoft.project.Elearning.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.role.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
}
