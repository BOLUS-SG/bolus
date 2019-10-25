package com.bolus.backend.development.admin.service;

import java.util.List;

import com.bolus.backend.development.employee.model.Employee;

public interface IStaffOperationsService {
	
	public Employee addEmployeeService(Employee employee);
	public List<Employee> getEmployeeList(String type);
	public Employee getEmployeeIdByPhone(Long phone);
}
