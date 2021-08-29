package cybersoft.project.Elearning.CommonData;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import cybersoft.project.Elearning.Ultils.Dateultils;
import lombok.Getter;
import lombok.Setter;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class AbstractEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private int version;
	
	@JsonFormat(shape = Shape.STRING,pattern = Dateultils.DATE_FORMAT)
	@CreatedDate
	@DateTimeFormat(pattern = Dateultils.DATE_FORMAT)
	private LocalDateTime created;
	
	
	@JsonFormat(shape = Shape.STRING,pattern = Dateultils.DATE_FORMAT)
	@CreatedDate
	@DateTimeFormat(pattern = Dateultils.DATE_FORMAT)
	private LocalDateTime update;
	
	@CreatedBy
	private String createBy;
	
	@LastModifiedBy
	private String updateBy;
	
	
}
