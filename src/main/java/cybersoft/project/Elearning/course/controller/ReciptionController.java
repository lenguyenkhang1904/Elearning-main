package cybersoft.project.Elearning.course.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.project.Elearning.CommonData.ResponseCode;
import cybersoft.project.Elearning.CommonData.ResponseObject;
import cybersoft.project.Elearning.Ultils.Errorutils;
import cybersoft.project.Elearning.course.Dto.BuyCourse;
import cybersoft.project.Elearning.course.Service.CourseService;
import cybersoft.project.Elearning.course.model.ReciptionCourse;
import lombok.Setter;

@RestController
@RequestMapping("/api/Reciption")
public class ReciptionController {
	
	@Autowired
	private CourseService service;
	@GetMapping("")
	public ResponseEntity<Object> findAll()
	{
		List<ReciptionCourse> list=service.ListofReciption();
		if (list.isEmpty())
			return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ResponseObject(list),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> Buy(@Valid @RequestBody BuyCourse  buy,BindingResult errors)
	{
		ReciptionCourse reciptionCourse=service.MapUserBuyCoursetoAll(buy);
		if(errors.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(errors.getAllErrors())),HttpStatus.BAD_REQUEST);
		
		String code= new ResponseCode() 
				.generateCode();
		
		service.SaveCodeValidation(buy.getIdCourseForValidatorCode(), code);
		return new ResponseEntity<>(new ResponseObject(code),HttpStatus.OK);
	}
	
	
}
