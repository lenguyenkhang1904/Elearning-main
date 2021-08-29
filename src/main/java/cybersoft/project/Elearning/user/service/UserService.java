package cybersoft.project.Elearning.user.service;

import java.util.List;

import java.util.Optional;

import cybersoft.project.Elearning.user.dto.UserDto;
import cybersoft.project.Elearning.user.dto.UserUpdateDto;

import cybersoft.project.Elearning.user.model.User;

public interface UserService {
		User save(UserDto dto);
		
		List<User> findAllUser();
		
	
		
		User updateUser(UserUpdateDto dto);
		
		void deleteByID(Long id);
		
		boolean checkDuplicateUsername(String username);
		
		
		boolean checkDuplicateEmail(String email);

		boolean CheckExits(String value);
		
		boolean checkIdExits(Long id);
		
}
