package com.bolus.backend.development.admin.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.admin.service.IStaffOperationsService;
import com.bolus.backend.development.employee.model.Cook;
import com.bolus.backend.development.employee.model.DeliveryBoy;
import com.bolus.backend.development.employee.model.Employee;
import com.bolus.backend.development.validation.constants.ValidationConstants;
import com.bolus.backend.development.validation.model.EmployeeValidationBean;
import com.bolus.backend.development.validation.service.IDBDetailsValidationService;

@RestController
@RequestMapping("/admin/staff")
public class StaffOperationsController {

	@Autowired
	private IStaffOperationsService staffOperationsService;

	@Autowired
	IDBDetailsValidationService dbDetailsValidationService;

	@Autowired
	ResponseDetails responseDetails;

	@RequestMapping(value = "/addCook", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Cook cook) {
		return staffOperationsService.addEmployeeService(cook);
	}

	@RequestMapping(value = "/addDeliveryBoy", method = RequestMethod.POST)
	public ResponseDetails addEmployee(@RequestBody DeliveryBoy deliveryBoy) {

		responseDetails  = dbDetailsValidationService.validateEmployeeDetails(deliveryBoy,
				responseDetails);
		if (responseDetails.getResponseMap().isEmpty()) {
			responseDetails = dbDetailsValidationService.validateUniqueDBDetails(deliveryBoy, responseDetails);
		} 
		
		if (responseDetails.getResponseMap().isEmpty()) {
			staffOperationsService.addEmployeeService(deliveryBoy);
			responseDetails.getResponseMap().put(ValidationConstants.SUCCESS_CODE,
					ValidationConstants.SUCCESS_CODE_MESSAGE);
		}

		return responseDetails;
	}

	@RequestMapping(value = "/employeeList/{type}", method = RequestMethod.GET)
	public List<Employee> viewEmployeeList(@PathVariable("type") String type) {
		List<Employee> employeeList = staffOperationsService.getEmployeeList(type);
		return employeeList;
	}

}
