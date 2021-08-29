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
import cybersoft.project.Elearning.user.dto.UserTypeDto;
import cybersoft.project.Elearning.user.dto.UserTypeUpdateDto;
import cybersoft.project.Elearning.user.model.UserType;
import cybersoft.project.Elearning.user.service.UserTypeService;

@RestController
@RequestMapping("/api/userType")
public class UserTypeController {
	
	@Autowired
	private UserTypeService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllUserType()
	{
		List<UserType> userTypes=service.findAll();
		if(userTypes.isEmpty())
			return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(new ResponseObject(userTypes),HttpStatus.OK);
		
	}
	
	@PostMapping("")
	public ResponseEntity<Object> saveUserType(@Valid @RequestBody UserTypeDto dto,BindingResult errors)
	{
		if(errors.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(errors.getAllErrors())),HttpStatus.BAD_REQUEST);
		
			UserType userType=service.save(dto);
		return new ResponseEntity<>(new ResponseObject(dto),HttpStatus.OK);
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Object> updateUser(@Valid @RequestBody UserTypeUpdateDto dto,BindingResult errors)
	{
		
		if(errors.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(errors.getAllErrors())),HttpStatus.BAD_REQUEST);
		
		
		UserType userType=service.updateUserType(dto);
		return new ResponseEntity<>(new ResponseObject(userType),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{idUserType}")
	public ResponseEntity<Object> deleteUserType(@PathVariable("idUserType") Long idUserType)
	{
		
		
		service.deleteUserType(idUserType);
		
		return new ResponseEntity<>(new ResponseObject("Successfully!!"),HttpStatus.OK);
	}
	
}
