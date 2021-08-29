package cybersoft.project.Elearning.role.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cybersoft.project.Elearning.CommonData.ResponseCode;
import cybersoft.project.Elearning.CommonData.ResponseObject;
import cybersoft.project.Elearning.Ultils.Errorutils;
import cybersoft.project.Elearning.Ultils.ResponseCodeCourse;
import cybersoft.project.Elearning.role.dto.AccountDto;
import cybersoft.project.Elearning.role.dto.RoleDto;
import cybersoft.project.Elearning.role.dto.RolewithAccount;
import cybersoft.project.Elearning.role.model.Accounts;
import cybersoft.project.Elearning.role.model.Role;
import cybersoft.project.Elearning.role.service.AccountService;
import cybersoft.project.Elearning.role.service.RoleService;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	@Autowired
	private RoleService service;
	@Autowired
	private AccountService serviceAccount;
	
	
	@GetMapping("")
	public ResponseEntity<Object> findAllRole()
	{
		List<Role> roles=service.findAll();
		
		return new ResponseEntity<>(new ResponseObject(roles),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> save(@Valid @RequestBody RoleDto dto,BindingResult errors)
	{
		if(errors.hasErrors())
			return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(errors.getAllErrors())),HttpStatus.BAD_REQUEST);
		
		Role role=service.save(dto);
		return new ResponseEntity<>(new ResponseObject(role),HttpStatus.OK);
		
	}
	@GetMapping("/{id_Role}")
	public ResponseEntity<Object> findById(@PathVariable(name = "id_Role") Long id_Role)
	{
		Optional<Role> role=service.findById(id_Role);
		if(role.isEmpty())
			return new ResponseEntity<>(new ResponseObject("no data"),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ResponseObject(role),HttpStatus.OK);
		
	}
	
	@GetMapping("/with-account")
	public ResponseEntity<Object> findAccount()
	{
		List<Accounts> account=serviceAccount.findall();
			
			if(account.isEmpty())
				return new ResponseEntity<>(new ResponseObject("there is no data"),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new ResponseObject(account),HttpStatus.OK);
	}
	
	@PostMapping("/save-account")
	public ResponseEntity<Object> saveAccount(@RequestBody AccountDto dto)
	{
		serviceAccount.save(dto);
		return new ResponseEntity<>(new ResponseObject("successfully"),HttpStatus.OK);
	}
	
	
	@PutMapping("/{idRole}")
	public ResponseEntity<Object> updateRole(@Valid @RequestBody RoleDto dto,BindingResult errors,@PathVariable(name="idRole") Long idRole)
	{
			Role role=service.updateRole(dto, idRole);
			
			if(errors.hasErrors())
				return new ResponseEntity<>(new ResponseObject(Errorutils.getMessage(errors.getAllErrors())),HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity<>(new ResponseObject(role),HttpStatus.OK);
	}
	
	@DeleteMapping("/{idRole}")
	public ResponseEntity<Object> deletebyId(@PathVariable(name="idRole") Long idRole)
	{
		
			
			service.deleteById(idRole);
			return new ResponseEntity<>(new ResponseObject("successful"),HttpStatus.OK);
			
	}
}
	

