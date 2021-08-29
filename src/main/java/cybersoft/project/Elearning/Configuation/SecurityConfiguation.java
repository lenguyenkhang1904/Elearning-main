package cybersoft.project.Elearning.Configuation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cybersoft.project.Elearning.security.Jwt.AuthnenticationFilter;
import cybersoft.project.Elearning.user.Validation.Confirmpassword;

@Configuration
@EnableWebSecurity
public class SecurityConfiguation extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private AuthnenticationFilter filter;
	
	
	@Bean
	public PasswordEncoder getPassword()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(service)
		.passwordEncoder(getPassword());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors();
		
		http.csrf().disable();
		
		http.antMatcher("/api/**").authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/swagger-ui.html").permitAll()
		.antMatchers("/api/**").permitAll()
		.anyRequest().authenticated(); 
		
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
}
