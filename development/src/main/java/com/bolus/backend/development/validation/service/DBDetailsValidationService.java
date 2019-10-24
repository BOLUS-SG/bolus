package com.bolus.backend.development.validation.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.employee.model.DeliveryBoy;
import com.bolus.backend.development.validation.constants.ValidationConstants;
import com.bolus.backend.development.validation.dao.repository.IDBDetailsValidationRepository;
import com.bolus.backend.development.validation.model.EmployeeValidationBean;

@Service
public class DBDetailsValidationService implements IDBDetailsValidationService {

	@Autowired
	private ValidatorFactory validatorFactory;
	@Autowired
	IDBDetailsValidationRepository dBDetailsValidationRepository;

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
				responseDetails.getResponseMap().put(code, message);
			}

		} catch (FileNotFoundException exception) {
			responseDetails.getResponseMap().clear();
			code = ValidationConstants.UNKNOWN_ERROR_CODE;
			message = ValidationConstants.UNKNOWN_ERROR_CODE_MESSAGE;
			responseDetails.getResponseMap().put(code, message);
			System.out.println(exception.getMessage());
			return responseDetails;
		} catch (IOException exception) {
			responseDetails.getResponseMap().clear();
			code = ValidationConstants.UNKNOWN_ERROR_CODE;
			message = ValidationConstants.UNKNOWN_ERROR_CODE_MESSAGE;
			responseDetails.getResponseMap().put(code, message);
			System.out.println(exception.getMessage());
			return responseDetails;
		}

		return responseDetails;
	}

	@Override
	public ResponseDetails validateUniqueDBDetails(DeliveryBoy deliveryBoy, ResponseDetails responseDetails) {
		Set<String> responseCodeSet = new HashSet<String>();

		if (deliveryBoy.getEmail() != null || deliveryBoy.getEmail() != "") {
			if (dBDetailsValidationRepository.existsByEmail(deliveryBoy.getEmail())) {
				responseCodeSet.add(ValidationConstants.EMPLOYEE_EMAIL_INVALID_EMPTY);
			}
			if (dBDetailsValidationRepository.existsByPhone(deliveryBoy.getPhone())) {
				responseCodeSet.add(ValidationConstants.EMPLOYEE_PHONE_INVALID);
			}
			if (dBDetailsValidationRepository.existsByAltPhone(deliveryBoy.getAltPhone())) {
				responseCodeSet.add(ValidationConstants.EMPLOYEE_ALTPHONE_INVALID);
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
			}

			responseDetails.getResponseMap().put(code, message);

		} catch (FileNotFoundException exception) {
			responseDetails.getResponseMap().clear();
			code = ValidationConstants.UNKNOWN_ERROR_CODE;
			message = ValidationConstants.UNKNOWN_ERROR_CODE_MESSAGE;
			System.out.println(exception.getMessage());
			responseDetails.getResponseMap().put(code, message);
		} catch (IOException exception) {
			responseDetails.getResponseMap().clear();
			code = ValidationConstants.UNKNOWN_ERROR_CODE;
			message = ValidationConstants.UNKNOWN_ERROR_CODE_MESSAGE;
			System.out.println(exception.getMessage());
			responseDetails.getResponseMap().put(code, message);
		}

		return responseDetails;
	}
}
