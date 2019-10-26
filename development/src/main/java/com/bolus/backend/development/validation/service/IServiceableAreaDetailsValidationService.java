package com.bolus.backend.development.validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.admin.model.ServiceableAreas;
import com.bolus.backend.development.employee.model.Employee;
import com.bolus.backend.development.validation.model.EmployeeValidationBean;
import com.bolus.backend.development.validation.model.ServiceableAreaValidationBean;

public interface IServiceableAreaDetailsValidationService {

	public ResponseDetails getResponseDetails(Set<ConstraintViolation<ServiceableAreaValidationBean>> constraintViolations, ResponseDetails responseDetails);
	public ResponseDetails validateAreaDetails(
			ServiceableAreaValidationBean serviceableAreaValidationBean,ResponseDetails responseDetails);
	public ResponseDetails validateUniqueAreaDetails(ServiceableAreas serviceableAreas, ResponseDetails responseDetails);
	public ResponseDetails getUniqueResponseDetails(Set<String> responseCodeSet, ResponseDetails responseDetails);
}
