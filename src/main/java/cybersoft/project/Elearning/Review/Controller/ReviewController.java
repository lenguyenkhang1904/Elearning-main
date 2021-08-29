package cybersoft.project.Elearning.Review.Controller;

import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.project.Elearning.CommonData.ResponseObject;
import cybersoft.project.Elearning.Review.Dto.ReviewDto;
import cybersoft.project.Elearning.Review.Service.ReviewService;
import cybersoft.project.Elearning.Review.model.Review;
import cybersoft.project.Elearning.Ultils.Errorutils;

@RestController
@RequestMapping("/api/Review")
public class ReviewController {
	@Autowired
	private ReviewService servivce;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllReview()
	{
		List<Review> review=servivce.findallReview();
		if(review.isEmpty())
			return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ResponseObject(review),HttpStatus.OK);
	}
	
	@PostMapping("/{codeCourse}")
	public ResponseEntity<Object> saveReview(@Valid @RequestBody ReviewDto dto,@PathVariable("codeCourse") String codeCourse,BindingResult result)
	{
		Review reiviewSave=servivce.save(dto, codeCourse);
		
		if(result.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(result.getAllErrors())),HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity<>(new ResponseObject(reiviewSave),HttpStatus.OK);
	}
	
}
