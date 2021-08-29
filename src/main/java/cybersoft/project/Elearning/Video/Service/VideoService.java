package cybersoft.project.Elearning.Video.Service;

import java.util.List;

import cybersoft.project.Elearning.Video.Dto.VideoDto;
import cybersoft.project.Elearning.Video.Model.Video;

public interface VideoService {
	
		List<Video> findAll();
	
		Video save(VideoDto dto);
		
		Video updateVideo(VideoDto dto,Long id);
		
		void deleteVideo(Long id);
		
		boolean checkDuplicateURL(String URL);
}
