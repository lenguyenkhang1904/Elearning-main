package cybersoft.project.Elearning.user.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.Ultils.MapModelToDto;
import cybersoft.project.Elearning.course.Dto.BuyCourse;
import cybersoft.project.Elearning.course.Repository.CourseRepository;
import cybersoft.project.Elearning.course.model.Course;
import cybersoft.project.Elearning.user.dto.UserBuyCourse;
import cybersoft.project.Elearning.user.model.User;
import cybersoft.project.Elearning.user.model.UserAccepted;
import cybersoft.project.Elearning.user.model.UserBought;
import cybersoft.project.Elearning.user.repository.UserBoughtRepository;
import cybersoft.project.Elearning.user.repository.UserRepository;

@Service
public class UserBoughtServiceIMPL implements UserBoughtService {
	
	@Autowired
	private UserBoughtRepository repository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MapModelToDto<Object, Object> mapper;
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserBoughtRepository boughtRepository;
	
	private void MaptoUserBought(UserAccepted accepted,UserBought user)
	{
		
		
		
			accepted.setUsername(user.getUsername());
	
			accepted.setCodeCourse(user.getCodeCourse());
			
			accepted.setEmail(user.getEmail());
			
			accepted.setFullname(user.getFullname());
		
	}
	
	
	private List<UserAccepted> ListUserMap(List<UserBought> users)
	{
		List<UserAccepted> list=new LinkedList<>();
		for (UserBought user : users ) {
			
				UserAccepted accepted=new UserAccepted();
				MaptoUserBought(accepted, user);
				list.add(accepted);
			
		}
		return list;
	}
	
	public List<UserAccepted> findall()
	{
		List<UserBought> users= boughtRepository.findAll();
		

		
		List<UserAccepted> accepteds=ListUserMap(users);
		
		return accepteds;
	}


	@Override
	public UserBought save(UserBuyCourse buyCourse) {
		// TODO Auto-generated method stub
		UserBought buy=new UserBought();
		
		buy=(UserBought)mapper.MapToDto(buyCourse, buy);
		
		
		
		
		
		
		
		
		
		return repository.save(buy);
	}
	
}
