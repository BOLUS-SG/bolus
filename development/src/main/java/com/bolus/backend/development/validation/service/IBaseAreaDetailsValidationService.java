package com.bolus.backend.development.validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.admin.model.States;
import com.bolus.backend.development.validation.model.BaseAreaValidationBean;
import com.bolus.backend.development.validation.model.EmployeeValidationBean;

public interface IBaseAreaDetailsValidationService {

	public ResponseDetails validateBaseAreaDetails(BaseAreaValidationBean baseAreaValidationBean,
			ResponseDetails responseDetails);

	public ResponseDetails getResponseDetails(Set<ConstraintViolation<BaseAreaValidationBean>> constraintViolations,
			ResponseDetails responseDetails);
	
	public ResponseDetails validateUniqueBaseAreaDetails(States state, ResponseDetails responseDetails);

	public ResponseDetails getUniqueResponseDetails(Set<String> responseCodeSet, ResponseDetails responseDetails);

}
