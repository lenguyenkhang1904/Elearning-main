package cybersoft.project.Elearning.Video.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.project.Elearning.Video.Validation.UniqueURL;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VideoDto {

	
	@NotBlank(message = "{Video.title.notblank}")
	@Size(min = 2,max = 20,message = "{Video.title.size}")
	private String title;
	
	@UniqueURL
	@NotBlank(message = "{Video.URL.notblank}")
	private String URL;
	
	
	private int time_count ;
	
}
