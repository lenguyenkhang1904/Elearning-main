package cybersoft.project.Elearning.role.service;

import javax.validation.Valid;

import cybersoft.project.Elearning.role.dto.RoleDto;
import cybersoft.project.Elearning.role.model.Role;
import cybersoft.project.Elearning.role.model.RoleGroup;



public interface RoleGroupService {
	RoleGroup addRole(@Valid Role role,Long groupId);
	 RoleGroup  updateRoleInfo(@Valid RoleDto dto ,Long roleid);
	 void deleteRole(Long roleid);
}
