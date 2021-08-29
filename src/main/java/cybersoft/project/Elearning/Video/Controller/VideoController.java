package cybersoft.project.Elearning.Video.Controller;

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
import cybersoft.project.Elearning.Video.Dto.VideoDto;
import cybersoft.project.Elearning.Video.Model.Video;
import cybersoft.project.Elearning.Video.Service.VideoService;

@RestController
@RequestMapping("/api/video")
public class VideoController {
	@Autowired
	private VideoService service;
	
	@GetMapping("/findAll")
	public ResponseEntity<Object> findall()
	{
		List<Video> videos=service.findAll();
		if(videos.isEmpty())
			return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ResponseObject(videos),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> saveVideo(@Valid @RequestBody VideoDto dto,BindingResult error)
	{
		Video video=service.save(dto);
		if(error.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(error.getAllErrors())),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ResponseObject(video),HttpStatus.OK);
			
	}
	@PutMapping("/{idVideo}")
	public ResponseEntity<Object> UpdateVideo(@Valid @RequestBody VideoDto dto,@PathVariable("idVideo") Long idVideo,BindingResult error)
	{
		Video videoupdate=service.updateVideo(dto, idVideo);
		if(error.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(error.getAllErrors())),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(new ResponseObject(videoupdate),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> DeleteVideo(@PathVariable("id") Long id)
	{
		service.deleteVideo(id);
		if(id==null)
			return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(new ResponseObject("Delete Successfully"),HttpStatus.OK);
	}
}
