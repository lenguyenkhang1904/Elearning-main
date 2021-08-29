package cybersoft.project.Elearning.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.role.model.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {

}
