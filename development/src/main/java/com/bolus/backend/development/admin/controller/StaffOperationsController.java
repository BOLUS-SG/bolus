package com.bolus.backend.development.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolus.backend.development.admin.service.IStaffOperationsService;
import com.bolus.backend.development.employee.model.Cook;
import com.bolus.backend.development.employee.model.DeliveryBoy;
import com.bolus.backend.development.employee.model.Employee;

@RestController
@RequestMapping("/admin/staff")
public class StaffOperationsController {

	@Autowired
	private IStaffOperationsService staffOperationsService;

	@RequestMapping(value = "/addCook", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Cook cook) {
		return staffOperationsService.addEmployeeService(cook);
	}

	@RequestMapping(value = "/addDeliveryBoy", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody DeliveryBoy deliveryBoy) {
		return staffOperationsService.addEmployeeService(deliveryBoy);
	}

	@RequestMapping(value = "/employeeList/{type}", method = RequestMethod.GET)
	public List<Employee> viewEmployeeList(@PathVariable("type") String type) {
		List<Employee> employeeList = staffOperationsService.getEmployeeList(type);
		return employeeList;
	}

}
