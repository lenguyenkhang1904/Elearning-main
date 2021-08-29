package cybersoft.project.Elearning.role.service;

import java.util.List;

import cybersoft.project.Elearning.role.dto.AccountDto;
import cybersoft.project.Elearning.role.dto.RolewithAccount;
import cybersoft.project.Elearning.role.model.Accounts;

public interface AccountService {
	void save(AccountDto dto);
	List<Accounts> findall();
}
