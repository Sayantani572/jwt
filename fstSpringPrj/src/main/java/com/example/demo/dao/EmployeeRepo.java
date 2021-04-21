package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	//Optional<Employee> findByEmail(String email);

	Optional<Employee> findByUserName(String username);
}
