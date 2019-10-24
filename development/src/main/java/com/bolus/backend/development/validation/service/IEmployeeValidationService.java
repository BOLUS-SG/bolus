package com.bolus.backend.development.validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.bolus.backend.development.employee.model.Cook;
import com.bolus.backend.development.employee.model.DeliveryBoy;
import com.bolus.backend.development.validation.model.EmployeeValidationBean;

public interface IEmployeeValidationService {

	public Set<ConstraintViolation<EmployeeValidationBean>> validateEmployeeDetails(
			EmployeeValidationBean employeeValidationBean);
}
