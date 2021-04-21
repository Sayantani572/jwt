package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@Column(name = "name")
	String name;
	
	float sal;
	
	@Column(name = "city")
	String city;
	
	String email;
	
	String userName;
	String password;
	
	boolean active;
	
	String roles;
	
	public Employee(Employee emp) {
		this.email=emp.getEmail();
		this.password=emp.getPassword();
		this.userName=emp.getUserName();
		this.name=emp.getName();
		this.sal=emp.getSal();
		this.city=emp.getCity();
		this.active=emp.isActive();
		this.roles=emp.getRoles();
	}

}
