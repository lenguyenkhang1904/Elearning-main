package cybersoft.project.Elearning.Video.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.project.Elearning.Video.Model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
	
	
	int countByURL(String URL);
	
	
	
	
}
