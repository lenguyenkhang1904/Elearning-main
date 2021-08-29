package cybersoft.project.Elearning.Configuation;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.Jwts;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguation {

	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(Arrays.asList(getApiKey()))
				.securityContexts(Arrays.asList(getSecurityContext()))
				.select()
				.apis(RequestHandlerSelectors.basePackage("cybersoft.project.Elearning"))
				.build()
				.apiInfo(getApiInfo());
	}
	
	public ApiInfo getApiInfo()
	{
		return new ApiInfoBuilder()
				.title("API of E-Learning")
				.description("hi")
				.contact(new Contact("khang","khangle", "not"))
				.license("MIT2")
				.build();
	}
	
	public ApiKey getApiKey()
	{
		return new ApiKey("JWT","Authorization","header");
	}
	
	
	public SecurityContext getSecurityContext()
	{
		return SecurityContext.builder()
				.securityReferences(getSecurityReference())
				.build();
	}
	
	public List<SecurityReference> getSecurityReference()
	{
		AuthorizationScope authorizationScope=new AuthorizationScope("global","application can access");
		AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
		authorizationScopes[0]=authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
	
}
