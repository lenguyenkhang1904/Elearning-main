package cybersoft.project.Elearning.user.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import cybersoft.project.Elearning.CommonData.ResponseObject;
import cybersoft.project.Elearning.Ultils.Errorutils;
import cybersoft.project.Elearning.user.dto.UserBuyCourse;
import cybersoft.project.Elearning.user.dto.UserDto;
import cybersoft.project.Elearning.user.dto.UserUpdateDto;

import cybersoft.project.Elearning.user.model.User;
import cybersoft.project.Elearning.user.model.UserAccepted;
import cybersoft.project.Elearning.user.model.UserBought;
import cybersoft.project.Elearning.user.service.UserBoughtService;
import cybersoft.project.Elearning.user.service.UserService;
import cybersoft.project.Elearning.user.service.UserTypeService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@Autowired
	private UserTypeService typeService;
	
	@Autowired
	private UserBoughtService boughtService;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllUser()
	{
		List<User> users=service.findAllUser();
		if(users.isEmpty())
			return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ResponseObject(users),HttpStatus.OK);
		
		
	}
	
	@PostMapping("")
	public ResponseEntity<Object> save(@Valid @RequestBody UserDto dto,BindingResult errors)
	{
		
		if(errors.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(errors.getAllErrors())),HttpStatus.BAD_REQUEST);
		User user=service.save(dto);
		return new ResponseEntity<>(new ResponseObject(user),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/UserNotApproveACourse")
	public ResponseEntity<Object> UserNotApproveAttendCourse(@Valid @RequestBody UserBought userBought,BindingResult errors)
	{
		
		return null;
	}
	
	@PostMapping("/UserBuy")
	public ResponseEntity<Object> UserApproveCourse(@Valid @RequestBody UserBuyCourse userBuy,BindingResult errors)
	{
		UserBought userBought=boughtService.save(userBuy);
		
		List<UserAccepted> lists=boughtService.findall();
		
		if(errors.hasErrors())
			
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(errors.getAllErrors())),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ResponseObject(lists),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> UpdateUser(@Valid @RequestBody UserUpdateDto dto,BindingResult errors)
	{
		
		if(errors.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(errors.getAllErrors())),HttpStatus.BAD_REQUEST);
		
		User userUpdate=service.updateUser(dto);
		
		
		return new ResponseEntity<>(new ResponseObject(userUpdate),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idUser}")
	public ResponseEntity<Object> delete(@Valid @PathVariable(name="idUser") Long idUser)
	{
		
				
			service.deleteByID(idUser);
		return new ResponseEntity<>(new ResponseObject("Succesfull"),HttpStatus.OK);
	}
	
}
