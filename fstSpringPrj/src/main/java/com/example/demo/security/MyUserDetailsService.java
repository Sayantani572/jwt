package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.entity.Employee;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	EmployeeRepo repo;
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Optional<Employee> emp=repo.findByEmail(email);
//		
//		emp.orElseThrow(()-> new UsernameNotFoundException("No user found"));
//		
//		return emp.map(MyUserDetails::new).get();
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> emp =repo.findByUserName(username);
		emp.orElseThrow(()-> new UsernameNotFoundException("No user found"));
		return emp.map(MyUserDetails::new).get();
	}
	

}
