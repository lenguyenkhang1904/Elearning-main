package cybersoft.project.Elearning.Configuation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import com.sun.xml.bind.v2.model.core.ID;

import cybersoft.project.Elearning.CommonData.AuditorAwareIMPL;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAudi")
public class JPAconfiguation {
	
	@Bean
	AuditorAware<String> getAudi()
	{
		return new AuditorAwareIMPL();
	}
	
	@Component
	public interface generic<T> extends JpaRepository<T, ID>
	{
		
	}
}
