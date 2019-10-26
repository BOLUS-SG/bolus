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
import org.springframework.util.ResourceUtils;

import com.bolus.backend.development.ErrorHandling.ResponseDTO;
import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.admin.model.ServiceableAreas;
import com.bolus.backend.development.validation.constants.ValidationConstants;
import com.bolus.backend.development.validation.dao.repository.IServiceableAreaDetailsValidationRepository;
import com.bolus.backend.development.validation.model.BaseAreaValidationBean;
import com.bolus.backend.development.validation.model.ServiceableAreaValidationBean;

public class ServiceableAreaDetailsValidationService implements IServiceableAreaDetailsValidationService{

	@Autowired
	ValidatorFactory validatorFactory;
	
	@Autowired
	IServiceableAreaDetailsValidationRepository serviceableAreaDetailsValidationRepository;
	
	@Override
	public ResponseDetails getResponseDetails(
			Set<ConstraintViolation<ServiceableAreaValidationBean>> constraintViolations,
			ResponseDetails responseDetails) {
		String code = null;
		String message = null;
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:ValidationMessages.properties");
			InputStream in = new FileInputStream(file);
			Properties properties = new Properties();
			for (ConstraintViolation<ServiceableAreaValidationBean> violation : constraintViolations) {
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
	public ResponseDetails validateAreaDetails(ServiceableAreaValidationBean serviceableAreaValidationBean,
			ResponseDetails responseDetails) {
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<ServiceableAreaValidationBean>> constraintViolations = validator
				.validate(serviceableAreaValidationBean);
		if (constraintViolations.size() > 0) {
			responseDetails = getResponseDetails(constraintViolations, responseDetails);
		}
		return responseDetails;
	}

	@Override
	public ResponseDetails validateUniqueAreaDetails(ServiceableAreas serviceableArea, ResponseDetails responseDetails) {
		
		Set<String> responseCodeSet = new HashSet<String>();

		if(serviceableAreaDetailsValidationRepository.existsByName(serviceableArea.getName())) {
			responseCodeSet.add(ValidationConstants.SERVICEABLE_AREA_NAME_EXISTS);
		}
		
		if (responseCodeSet.size() > 0) {
			responseDetails = getUniqueResponseDetails(responseCodeSet, responseDetails);
		}

		return responseDetails;
	}

	@Override
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
