package com.bolus.backend.development.validation.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import com.bolus.backend.development.admin.model.Areas;
import com.bolus.backend.development.admin.model.Cities;
import com.bolus.backend.development.admin.model.Pincodes;
import com.bolus.backend.development.admin.model.States;
import com.bolus.backend.development.validation.constants.ValidationConstants;
import com.bolus.backend.development.validation.dao.repository.IBaseAreaAreaDetailsValidationRepository;
import com.bolus.backend.development.validation.dao.repository.IBaseAreaCityDetailsValidationRepository;
import com.bolus.backend.development.validation.dao.repository.IBaseAreaDetailsValidationRepository;
import com.bolus.backend.development.validation.dao.repository.IBaseAreaPincodeDetailsValidationRepository;
import com.bolus.backend.development.validation.model.BaseAreaValidationBean;

@Service
public class BaseAreaDetailsValidationService implements IBaseAreaDetailsValidationService{

	@Autowired
	private ValidatorFactory validatorFactory;
	
	@Autowired
	IBaseAreaDetailsValidationRepository baseAreaDetailsValidationRepository;
	
	@Autowired
	IBaseAreaCityDetailsValidationRepository baseAreaCityDetailsValidationRepository;
	
	@Autowired
	IBaseAreaAreaDetailsValidationRepository baseAreaAreaDetailsValidationRepository;
	
	@Autowired
	IBaseAreaPincodeDetailsValidationRepository baseAreaPincodeDetailsValidationRepository;
	
	@Override
	public ResponseDetails validateBaseAreaDetails(BaseAreaValidationBean baseAreaValidationBean,
			ResponseDetails responseDetails) {
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<BaseAreaValidationBean>> constraintViolations = validator
				.validate(baseAreaValidationBean);
		if (constraintViolations.size() > 0) {
			responseDetails = getResponseDetails(constraintViolations, responseDetails);
		}
		return responseDetails;
	}
	
	public ResponseDetails getResponseDetails(Set<ConstraintViolation<BaseAreaValidationBean>> constraintViolations,
			ResponseDetails responseDetails) {

		String code = null;
		String message = null;
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:ValidationMessages.properties");
			InputStream in = new FileInputStream(file);
			Properties properties = new Properties();
			for (ConstraintViolation<BaseAreaValidationBean> violation : constraintViolations) {
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
	public ResponseDetails validateUniqueBaseAreaDetails(States state,
			ResponseDetails responseDetails) {
		
		Set<String> responseCodeSet = new HashSet<String>();

		if(baseAreaDetailsValidationRepository.existsByState(state.getState())) {
			responseCodeSet.add(ValidationConstants.BASE_AREA_STATE_EXISTS);
		}
		
		List<String> cities = new ArrayList<String>();
		List<String> areas = new ArrayList<String>();
		List<String> pincodes = new ArrayList<String>();
		List<Cities> cityList = state.getCities();
		List<List<Areas>> areaList = new ArrayList<List<Areas>>();
		List<List<Pincodes>> pincodeList = new ArrayList<List<Pincodes>>();
		for(Cities c:cityList) {
			cities.add(c.getCity());
			areaList.add(c.getAreas());
			pincodeList.add(c.getPincodes());
		}
		for(List<Areas> list:areaList) {
			for(Areas a:list) {
				areas.add(a.getArea());
			}
		}
		for(List<Pincodes> list:pincodeList) {
			for(Pincodes p:list) {
				pincodes.add(p.getPincode());
			}
		}
		
		if(baseAreaCityDetailsValidationRepository.existsByCityIn(cities)) {
			responseCodeSet.add(ValidationConstants.BASE_AREA_CITY_EXISTS);
		}
		if(baseAreaAreaDetailsValidationRepository.existsByAreaIn(areas)) {
			responseCodeSet.add(ValidationConstants.BASE_AREA_AREA_EXISTS);
		}
		if(baseAreaPincodeDetailsValidationRepository.existsByPincode(pincodes)) {
			responseCodeSet.add(ValidationConstants.BASE_AREA_PINCODE_EXISTS);
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

	


