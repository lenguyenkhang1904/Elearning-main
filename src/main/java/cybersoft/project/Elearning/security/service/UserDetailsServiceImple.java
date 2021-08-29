package cybersoft.project.Elearning.security.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.role.model.RoleGroup;
import cybersoft.project.Elearning.security.dto.UserDetailDto;
import cybersoft.project.Elearning.user.model.User;
import cybersoft.project.Elearning.user.repository.UserRepository;
@Service
public class UserDetailsServiceImple implements UserDetailsService {

	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<User> user=repository.findByUsername(username);
		

		if(!user.isPresent())
			throw new UsernameNotFoundException("Username is invalid.");
		
		
		
		Set<GrantedAuthority> authority=getAuthority(user.get().getRoles());
		
		
		
		return new UserDetailDto(user.get().getUsername(), user.get().getPassword(), authority);
	}

	private Set<GrantedAuthority> getAuthority(Set<RoleGroup> groups) {
		
		// TODO Auto-generated method stub
		
		Set<GrantedAuthority> autho=new HashSet<>();
		
		Iterator<RoleGroup> iterator=groups.iterator();
		
		
		while(iterator.hasNext())
		{
			SimpleGrantedAuthority simplegrantedAuthority=new SimpleGrantedAuthority(iterator.next().getGroupname());
			autho.add(simplegrantedAuthority);
		}
		
		
		
		
		return autho;
	}

}
