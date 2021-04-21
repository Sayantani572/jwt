package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.entity.Employee;
import com.example.demo.util.AuthenticationReqest;
import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private JwtUtil jwtUtil;
 
	@Autowired
   private	EmployeeRepo repo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/employee")
	public String saveEmployee(@RequestBody Employee  emp) {
		
		if(emp.getRoles()==null || emp.isActive()==false) {
			emp.setRoles("ROLE_USER");
			emp.setActive(true);
		}
		System.out.print(emp);
		repo.save(emp);
		
		return "Successfully registered: "+emp.toString();	
	}
	
	//@PreAuthorize("hasRole('USER')")
	@RequestMapping("/emp")
	public List<Employee> findEmployee() {
	List<Employee> allEmp=repo.findAll();
	return allEmp;
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthenticationReqest authrequest) throws Exception{
	
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authrequest.getUserName(), authrequest.getPassword()));
	
	}catch(Exception ex) {
	 throw new Exception("Invalid Username and password");
	}
	return jwtUtil.generateToken(authrequest.getUserName());
	}
		
	}

