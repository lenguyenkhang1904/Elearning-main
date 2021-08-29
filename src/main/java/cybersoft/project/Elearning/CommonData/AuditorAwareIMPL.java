package cybersoft.project.Elearning.CommonData;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareIMPL implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		
		String currentUser=SecurityContextHolder.getContext().getAuthentication().getName();
		return Optional.ofNullable(currentUser);
	}

}
