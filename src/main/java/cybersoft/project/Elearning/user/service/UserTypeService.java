package cybersoft.project.Elearning.user.service;


import java.util.List;

import cybersoft.project.Elearning.user.dto.UserTypeDto;
import cybersoft.project.Elearning.user.dto.UserTypeUpdateDto;
import cybersoft.project.Elearning.user.model.UserType;

public interface UserTypeService {
		UserType save(UserTypeDto dto);
		
		List<UserType> findAll();
		
		
		
		UserType updateUserType(UserTypeUpdateDto dto);
		
		
		 void deleteUserType(Long id);

		boolean CheckExistUserType(String value);
		
		boolean CheckIDUserType(Long id);
}
