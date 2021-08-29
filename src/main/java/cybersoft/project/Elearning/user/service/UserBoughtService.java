package cybersoft.project.Elearning.user.service;

import java.util.List;

import cybersoft.project.Elearning.user.dto.UserBuyCourse;
import cybersoft.project.Elearning.user.model.UserAccepted;
import cybersoft.project.Elearning.user.model.UserBought;

public interface UserBoughtService {
	List<UserAccepted> findall();
	
	UserBought save(UserBuyCourse buyCourse);
}
