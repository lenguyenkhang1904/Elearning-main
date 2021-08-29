package cybersoft.project.Elearning.user.service;

import java.util.HashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.Ultils.MapModelToDto;
import cybersoft.project.Elearning.course.Repository.CourseRepository;
import cybersoft.project.Elearning.course.model.Course;
import cybersoft.project.Elearning.user.dto.UserBuyCourse;
import cybersoft.project.Elearning.user.dto.UserDto;
import cybersoft.project.Elearning.user.dto.UserUpdateDto;
import cybersoft.project.Elearning.user.model.User;
import cybersoft.project.Elearning.user.model.UserType;
import cybersoft.project.Elearning.user.repository.UserRepository;
import cybersoft.project.Elearning.user.repository.UserTypeRepository;
import io.jsonwebtoken.Jwts;

@Service
public class UserServiceIMPL implements UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder password;
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@Autowired
	private MapModelToDto<Object, User> mapper;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	@Override
	public User save(UserDto dto) {
		// TODO Auto-generated method stub
		
		User user=new User();
		user=mapper.MapToDto(dto, user);
		user.setPassword(password.encode(dto.getPassword()));
		
		Optional<UserType> usertype=userTypeRepository.findByCodeUser(dto.getCodeUser());
		if(usertype.isPresent())
			user.setUserType(usertype.get());	
		
		return userRepository.save(user);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public boolean checkDuplicateUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.countByUsername(username)>=1;
	}

	@Override
	public boolean checkDuplicateEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.countByEmail(email)>=1;
	}

	


	@Override
	public User updateUser(UserUpdateDto dto) {
		// TODO Auto-generated method stub
		
		User user=userRepository.getOne(dto.getId());
		
		user=mapper.MapToDto(dto, user);
		Double updatebalance=userRepository.UpdateBalance(dto.getId());
		
		updatebalance=updatebalance+dto.getBalance();
		
		user.setBalance(updatebalance);
		
		
		return userRepository.save(user);
	}

	@Override
	public void deleteByID(Long id) {
		// TODO Auto-generated method stub
		
		userRepository.deleteById(id);
	}

	@Override
	public boolean CheckExits(String value) {
		// TODO Auto-generated method stub
		return userRepository.countByUsername(value)==1;
	}

	@Override
	public boolean checkIdExits(Long id) {
		// TODO Auto-generated method stub
		return userRepository.countById(id)==1;
	}



	
	
	
}
