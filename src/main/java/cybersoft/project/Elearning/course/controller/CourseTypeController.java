package cybersoft.project.Elearning.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.project.Elearning.CommonData.ResponseObject;
import cybersoft.project.Elearning.Ultils.Errorutils;
import cybersoft.project.Elearning.course.Dto.CourseCategorydto;
import cybersoft.project.Elearning.course.Service.CourseCategoryService;
import cybersoft.project.Elearning.course.Service.CourseCategoryServiceImPL;
import cybersoft.project.Elearning.course.model.CourseCategory;

@RestController
@RequestMapping("/api/courseType")
public class CourseTypeController {
	
	@Autowired
	private CourseCategoryService categoryService;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllcatefory()
	{
		List<CourseCategory> categories=categoryService.findall();
		if(categories.isEmpty())
			return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(new ResponseObject(categories),HttpStatus.OK);
	}
	@PostMapping("")
	public ResponseEntity<Object> addCourse(@RequestBody CourseCategorydto dto,BindingResult result)
	{
		CourseCategory category=categoryService.save(dto);
		if(result.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(result.getAllErrors())),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(category,HttpStatus.OK);
	}
	
}
