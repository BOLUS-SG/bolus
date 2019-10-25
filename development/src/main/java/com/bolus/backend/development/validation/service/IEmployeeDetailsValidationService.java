package com.bolus.backend.development.validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.employee.model.Employee;
import com.bolus.backend.development.validation.model.EmployeeValidationBean;

public interface IEmployeeDetailsValidationService {
	
	public ResponseDetails getResponseDetails(Set<ConstraintViolation<EmployeeValidationBean>> constraintViolations, ResponseDetails responseDetails);
	public ResponseDetails validateEmployeeDetails(
			EmployeeValidationBean employeeValidationBean,ResponseDetails responseDetails);
	public ResponseDetails validateUniqueDBDetails(Employee employee, ResponseDetails responseDetails);
	public ResponseDetails getUniqueResponseDetails(Set<String> responseCodeSet, ResponseDetails responseDetails);

}
