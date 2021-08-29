package cybersoft.project.Elearning.CommonData;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import cybersoft.project.Elearning.Ultils.Dateultils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseObject {
	private Object content;
	private List<String> errormessages;
	private String responseTime=Dateultils.toString(LocalDateTime.now());
	
	
	//tạo constructor để hiện lên UI thôi
	 //hí hí
	public ResponseObject(Object content)
	{
		this.content=content;
		this.errormessages=new LinkedList<>();
	}
	public ResponseObject(List<String> errorMess)
	{
		this.errormessages=errorMess;
		content=new LinkedList<>();
	}
	
}
