package com.bolus.backend.development.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolus.backend.development.admin.dao.repository.IStaffOperationsRepository;
import com.bolus.backend.development.employee.model.Employee;

@Service
public class StaffOperationsService implements IStaffOperationsService{

	@Autowired
	private IStaffOperationsRepository staffOperationsRepository;
	
	public Employee addEmployeeService(Employee employee) {
		return staffOperationsRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeeList(String type) {
		return staffOperationsRepository.findByType(type);
	}

	@Override
	public Employee getEmployeeIdByPhone(Long phone) {
		return staffOperationsRepository.findByPhone(phone);
	}
	

}
