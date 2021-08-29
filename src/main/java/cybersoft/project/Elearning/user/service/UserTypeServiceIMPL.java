package cybersoft.project.Elearning.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.user.dto.UserTypeDto;
import cybersoft.project.Elearning.user.dto.UserTypeUpdateDto;
import cybersoft.project.Elearning.user.dto.UserUpdateDto;
import cybersoft.project.Elearning.user.model.UserType;
import cybersoft.project.Elearning.user.repository.UserTypeRepository;
@Service
public class UserTypeServiceIMPL implements UserTypeService {

	@Autowired
	private UserTypeRepository repository;
	
	
	@Override
	public UserType save(UserTypeDto dto) {
		// TODO Auto-generated method stub
		
		UserType userType=new UserType()
				.getCodeUser(dto.getCodeUser())
				.getUserType(dto.getNameUserType());
		
		
		return repository.save(userType);
	}
	
	

	
	@Override
	public List<UserType> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	
	public UserType updateUserType(UserTypeUpdateDto dto)
	{
		UserType userType=repository.getOne(dto.getId());
		
		
		userType.setNameUserType(dto.getNameUserType());
		
		return repository.save(userType);
		
		
	}
	
	public void deleteUserType(Long id)
	{
		repository.deleteById(id);
	}




	@Override
	public boolean CheckExistUserType(String value) {
		// TODO Auto-generated method stub
		return repository.countByCodeUser(value)==1;
	}




	@Override
	public boolean CheckIDUserType(Long id) {
		// TODO Auto-generated method stub
		return repository.countById(id)==1 ;
	}
	
	
}
