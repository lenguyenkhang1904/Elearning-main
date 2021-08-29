package cybersoft.project.Elearning.role.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.role.dto.RoleDto;
import cybersoft.project.Elearning.role.model.Role;
import cybersoft.project.Elearning.role.model.RoleGroup;
import cybersoft.project.Elearning.role.repository.RoleGroupRepository;
import cybersoft.project.Elearning.role.repository.RoleRepository;

@Service
public class RoleGroupServiceimpl implements RoleGroupService {

	
	@Autowired
	private RoleGroupRepository repository;
	
	@Autowired
	private RoleRepository repositoryRole;
	
	@Override
	public RoleGroup addRole(@Valid Role role, Long groupId) {
		// TODO Auto-generated method stub
		
		RoleGroup roleGroup=repository.getOne(groupId);
		
		roleGroup.addRole(role);
		
		
		return repository.save(roleGroup);
	}

	@Override
	public RoleGroup updateRoleInfo(@Valid RoleDto dto, Long roleid) {
		// TODO Auto-generated method stub
		
		  
		
		
		
		return null;
	}

	@Override
	public void deleteRole(Long roleid) {
		// TODO Auto-generated method stub
		
	}
		
}
