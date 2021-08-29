package cybersoft.project.Elearning.role.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.role.dto.RoleDto;
import cybersoft.project.Elearning.role.dto.RolewithAccount;
import cybersoft.project.Elearning.role.model.Role;
import cybersoft.project.Elearning.role.repository.RoleRepository;
import io.swagger.annotations.Authorization;

@Service
public class RoleServiceIMPL implements RoleService {

	@Autowired
	private RoleRepository repos;
	
	@Override
	public Role save(@Valid RoleDto dto) {
		// TODO Auto-generated method stub
		
		Role role=new Role()
				.roleName(dto.getName())
				.roleDescription(dto.getDescription());
		return repos.save(role);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return repos.findAll();
	}

	@Override
	public Optional<Role> findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Role> role=repos.findById(id);
		return role ;
	}
	
	
	private void MapdtotoModel(Role role,RolewithAccount dto)
	{
			dto=new RolewithAccount();
			dto.setFullname(role.getName());
			dto.setAccounts(dto.getAccounts());
			dto.setIdRole(role.getId());
				
	}
	
	private List<RolewithAccount> mapToDtoList(List<Role> roles)
	{
		List<RolewithAccount> result=new LinkedList<>();
		for(Role role:roles)
		{
			RolewithAccount model=new RolewithAccount();
			MapdtotoModel(role,model);
			result.add(model);
		}
		
		return result;
	}
	
	public List<RolewithAccount> findalll()
	{
		List<Role> roles=repos.findAll();
		
		List<RolewithAccount> dto=mapToDtoList(roles);
		return dto;
	}

	@Override
	public Role updateRole(RoleDto dto, Long id) {
		// TODO Auto-generated method stub
		Role roles=repos.getOne(id);
		
		roles.roleName(dto.getName())
		.roleDescription(dto.getDescription());
		
		
		return repos.save(roles);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		repos.deleteById(id);
		
	}

}
