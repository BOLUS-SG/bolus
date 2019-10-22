package com.bolus.backend.development.admin.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.States;
import com.bolus.backend.development.employee.model.Employee;

public interface IStaffOperationsRepository extends JpaRepository<Employee, Integer>{
	public Employee save(Employee employee);
	public List<Employee> findByType(String type);
}
