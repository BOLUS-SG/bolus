package com.bolus.backend.development.validation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.employee.model.Employee;

public interface IEmployeeDetailsValidationRepository extends JpaRepository<Employee, Integer>{
	
	public boolean existsByEmail(String email);
	public boolean existsByPhone(Long phone);
	public boolean existsByAltPhone(Long altPhone);
}
