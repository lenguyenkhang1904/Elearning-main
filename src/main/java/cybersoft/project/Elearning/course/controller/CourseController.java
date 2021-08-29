package cybersoft.project.Elearning.course.controller;

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
import cybersoft.project.Elearning.course.Dto.CourseCategorydto;
import cybersoft.project.Elearning.course.Dto.CourseDto;
import cybersoft.project.Elearning.course.Dto.CourseUpdateDto;
import cybersoft.project.Elearning.course.Service.CourseService;
import cybersoft.project.Elearning.course.model.Course;
import cybersoft.project.Elearning.course.model.CourseCategory;

@RestController
@RequestMapping("/api/Course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllcatefory()
	{
		List<Course> categories=courseService.findall();
		if(categories.isEmpty())
			return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(new ResponseObject(categories),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addCourse(@Valid @RequestBody CourseDto dto,BindingResult result	)
	{
		if(result.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(result.getAllErrors())),HttpStatus.BAD_REQUEST);
		
		
		Course course=courseService.save(dto);
		return new ResponseEntity<>(course,HttpStatus.OK);
	}
	
	@PutMapping("")
	public ResponseEntity<Object> UpdateCourse(@Valid @RequestBody CourseUpdateDto dto,BindingResult result)
	{
		
		if(result.hasErrors())
				return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		Course course=courseService.updateCourse(dto);
		return new ResponseEntity<>(new ResponseObject(course),HttpStatus.OK);
	}
	
	@DeleteMapping("/{codeCourse}")
	public ResponseEntity<Object> deleteCourse(@PathVariable("codeCourse") Long codeCourse)
	{
		courseService.deleteCourse(codeCourse);
		
		return new ResponseEntity<>(new ResponseObject("Successfully"),HttpStatus.OK);
	}
	
	
}
