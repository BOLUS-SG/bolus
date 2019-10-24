package com.bolus.backend.development.validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolus.backend.development.employee.model.Employee;
import com.bolus.backend.development.validation.dao.repository.ICookDetailsValidationRepository;
import com.bolus.backend.development.validation.model.EmployeeValidationBean;



@Service
public class EmployeeValidationService implements IEmployeeValidationService{

	@Autowired
	private ValidatorFactory validatorFactory;	
	
	@Override
	public Set<ConstraintViolation<EmployeeValidationBean>> validateEmployeeDetails(EmployeeValidationBean employeeValidationBean) {
		
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<EmployeeValidationBean>> constraintViolations = validator.validate(employeeValidationBean);		
		return constraintViolations;
	}

	
	
}
