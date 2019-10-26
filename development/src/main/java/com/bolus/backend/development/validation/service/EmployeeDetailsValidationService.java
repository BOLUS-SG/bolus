package com.bolus.backend.development.validation.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.bolus.backend.development.ErrorHandling.ResponseDTO;
import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.employee.model.Employee;
import com.bolus.backend.development.validation.constants.ValidationConstants;
import com.bolus.backend.development.validation.dao.repository.IEmployeeDetailsValidationRepository;
import com.bolus.backend.development.validation.model.EmployeeValidationBean;



@Service
public class EmployeeDetailsValidationService implements IEmployeeDetailsValidationService{
	
	@Autowired
	private ValidatorFactory validatorFactory;
	@Autowired
	IEmployeeDetailsValidationRepository EmployeeDetailsValidationRepository;

	@Override
	public ResponseDetails validateEmployeeDetails(EmployeeValidationBean employeeValidationBean,
			ResponseDetails responseDetails) {

		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<EmployeeValidationBean>> constraintViolations = validator
				.validate(employeeValidationBean);
		if (constraintViolations.size() > 0) {
			responseDetails = getResponseDetails(constraintViolations, responseDetails);
		}
		return responseDetails;
	}

	public ResponseDetails getResponseDetails(Set<ConstraintViolation<EmployeeValidationBean>> constraintViolations,
			ResponseDetails responseDetails) {

		String code = null;
		String message = null;
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:ValidationMessages.properties");
			InputStream in = new FileInputStream(file);
			Properties properties = new Properties();
			for (ConstraintViolation<EmployeeValidationBean> violation : constraintViolations) {
				properties.load(in);
				code = violation.getMessage();
				message = properties.getProperty(code);
				responseDetails.getResponseList().add(new ResponseDTO(code,message));
			}

		} catch (FileNotFoundException exception) {
			responseDetails.getResponseList().clear();
			code = ValidationConstants.UNKNOWN_ERROR_CODE;
			message = ValidationConstants.UNKNOWN_ERROR_CODE_MESSAGE;
			responseDetails.getResponseList().add(new ResponseDTO(code,message));
			System.out.println(exception.getMessage());
			return responseDetails;
		} catch (IOException exception) {
			responseDetails.getResponseList().clear();
			code = ValidationConstants.UNKNOWN_ERROR_CODE;
			message = ValidationConstants.UNKNOWN_ERROR_CODE_MESSAGE;
			responseDetails.getResponseList().add(new ResponseDTO(code,message));
			System.out.println(exception.getMessage());
			return responseDetails;
		}

		return responseDetails;
	}

	@Override
	public ResponseDetails validateUniqueDBDetails(Employee employee, ResponseDetails responseDetails) {
		Set<String> responseCodeSet = new HashSet<String>();

		if (employee.getEmail() != null || employee.getEmail() != "") {
			if (EmployeeDetailsValidationRepository.existsByEmail(employee.getEmail())) {
				responseCodeSet.add(ValidationConstants.EMPLOYEE_EMAIL_EXISTS);
			}
			if (EmployeeDetailsValidationRepository.existsByPhone(employee.getPhone())) {
				responseCodeSet.add(ValidationConstants.EMPLOYEE_PHONE_EXISTS);
			}
			if (EmployeeDetailsValidationRepository.existsByAltPhone(employee.getAltPhone())) {
				responseCodeSet.add(ValidationConstants.EMPLOYEE_ALTPHONE_EXISTS);
			}
		}

		if (responseCodeSet.size() > 0) {
			responseDetails = getUniqueResponseDetails(responseCodeSet, responseDetails);
		}

		return responseDetails;
	}

	public ResponseDetails getUniqueResponseDetails(Set<String> responseCodeSet, ResponseDetails responseDetails) {
		String code = null;
		String message = null;
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:ValidationMessages.properties");
			InputStream in = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(in);
			for (String codeExp : responseCodeSet) {
				code = properties.getProperty(codeExp);
				message = properties.getProperty(code);
				responseDetails.getResponseList().add(new ResponseDTO(code,message));
			}

		} catch (FileNotFoundException exception) {
			responseDetails.getResponseList().clear();
			code = ValidationConstants.UNKNOWN_ERROR_CODE;
			message = ValidationConstants.UNKNOWN_ERROR_CODE_MESSAGE;
			System.out.println(exception.getMessage());
			responseDetails.getResponseList().add(new ResponseDTO(code,message));
		} catch (IOException exception) {
			responseDetails.getResponseList().clear();
			code = ValidationConstants.UNKNOWN_ERROR_CODE;
			message = ValidationConstants.UNKNOWN_ERROR_CODE_MESSAGE;
			System.out.println(exception.getMessage());
			responseDetails.getResponseList().add(new ResponseDTO(code,message));
		}

		return responseDetails;
	}

	
	
}
