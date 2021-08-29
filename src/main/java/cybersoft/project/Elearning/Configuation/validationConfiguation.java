package cybersoft.project.Elearning.Configuation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
@Configuration
public class validationConfiguation  {
	@Bean
	public MessageSource messageSource()
	{
		ReloadableResourceBundleMessageSource messageSource
		=new ReloadableResourceBundleMessageSource();        //lấy message
		messageSource.setBasename("classpath:/Validation/messgae");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		
		LocalValidatorFactoryBean validator=new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
		
	}
}
