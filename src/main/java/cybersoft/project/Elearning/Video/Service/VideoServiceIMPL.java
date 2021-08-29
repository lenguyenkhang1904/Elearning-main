package cybersoft.project.Elearning.Video.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.Ultils.MapModelToDto;
import cybersoft.project.Elearning.Video.Dto.VideoDto;
import cybersoft.project.Elearning.Video.Model.Video;
import cybersoft.project.Elearning.Video.Repository.VideoRepository;

@Service
public class VideoServiceIMPL implements VideoService {

	
	@Autowired
	private VideoRepository repository;
	@Autowired
	private MapModelToDto<Object, Object> mapper;
	
	@Override
	public Video save(VideoDto dto) {
		// TODO Auto-generated method stub
		
		Video video=new Video();
		video=(Video) mapper.MapToDto(dto, video);
		
		
		
		return repository.save(video);
	}

	@Override
	public Video updateVideo(VideoDto dto, Long id) {
		// TODO Auto-generated method stub
		
		Video video=repository.getOne(id);
		
		video=(Video)mapper.MapToDto(dto, video);
		
		return repository.save(video);
	}

	@Override
	public void deleteVideo(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public boolean checkDuplicateURL(String URL) {
		// TODO Auto-generated method stub
		
		
		
		
		return repository.countByURL(URL)>=1;
	}

	@Override
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
