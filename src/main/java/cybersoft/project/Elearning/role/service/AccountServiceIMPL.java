package cybersoft.project.Elearning.role.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.project.Elearning.role.dto.AccountDto;
import cybersoft.project.Elearning.role.dto.RolewithAccount;
import cybersoft.project.Elearning.role.model.Accounts;
import cybersoft.project.Elearning.role.repository.AccountRepository;
import io.swagger.annotations.Authorization;

@Service
public class AccountServiceIMPL implements AccountService {
	@Autowired
	private AccountRepository repo;

	@Override
	public void save(AccountDto dto) {
		// TODO Auto-generated method stub
		
		Accounts account=new Accounts()
				.idRole(dto.getIdRole())
				.nameAccount(dto.getFullname())
				.usernameAccount(dto.getUsername());
		
		
		repo.save(account);
				
	}

	@Override
	public List<Accounts> findall() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	
}
