package com.example.demo.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entity.Employee;

public class MyUserDetails extends Employee implements UserDetails {
	
//    String email;
//	
//	String password;
//	
//	boolean active;
//	
//	List<GrantedAuthority> authorities;
//
//	public MyUserDetails() {
//	
//	}

	public MyUserDetails(final Employee emp) {
		super(emp);
//		this.email = emp.getEmail();
//		this.password = emp.getPassword();
//		this.active = emp.isActive();
//		this.authorities =Arrays.stream(emp.getRoles().split(","))
//				.map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());
	}
	private List<GrantedAuthority> authority;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.stream(super.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());			
	}

	


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}




	@Override
	public String getUsername() {
		
		return super.getUserName();
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
