package cybersoft.project.Elearning.role.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import cybersoft.project.Elearning.role.dto.RoleDto;
import cybersoft.project.Elearning.role.dto.RolewithAccount;
import cybersoft.project.Elearning.role.model.Role;

public interface RoleService {
	Role save(@Valid RoleDto dto);
	List<Role> findAll();
	Optional<Role> findById(Long id);
	List<RolewithAccount> findalll();
	Role updateRole(RoleDto dto,Long id);
	void deleteById(Long id);
	
	
	
}
