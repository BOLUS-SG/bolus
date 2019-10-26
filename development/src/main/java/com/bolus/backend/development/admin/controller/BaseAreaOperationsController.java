package com.bolus.backend.development.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolus.backend.development.ErrorHandling.ResponseDTO;
import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.admin.model.Areas;
import com.bolus.backend.development.admin.model.Cities;
import com.bolus.backend.development.admin.model.Pincodes;
import com.bolus.backend.development.admin.model.States;
import com.bolus.backend.development.admin.service.IBaseAreaOperationsService;
import com.bolus.backend.development.validation.constants.ValidationConstants;
import com.bolus.backend.development.validation.service.IBaseAreaDetailsValidationService;

@RestController
@RequestMapping("/admin/area/baseArea")
public class BaseAreaOperationsController {

	@Autowired
	IBaseAreaOperationsService baseAreaOperationsService;

	@Autowired
	IBaseAreaDetailsValidationService baseAreaDetailsValidationService;

	@Autowired
	ResponseDetails responseDetails;

	@RequestMapping(value = "/addBaseArea", method = RequestMethod.POST)
	public ResponseDetails addBaseAreaDetails(@RequestBody States state) {

		List<Cities> cityList = null;
		List<Areas> areaList = null;
		List<Pincodes> pincodeList = null;

		responseDetails.getResponseList().clear();
		responseDetails = baseAreaDetailsValidationService.validateBaseAreaDetails(state, responseDetails);
		if (responseDetails.getResponseList().isEmpty()) {
			cityList = state.getCities();
			for (Cities city : cityList) {
				responseDetails = baseAreaDetailsValidationService.validateBaseAreaDetails(city, responseDetails);
			}
		}
		if (responseDetails.getResponseList().isEmpty()) {
			for (Cities city : cityList) {
				areaList = city.getAreas();
				{
					for (Areas area : areaList) {
						responseDetails = baseAreaDetailsValidationService.validateBaseAreaDetails(area,
								responseDetails);
					}
				}
			}
		}
		
		if (responseDetails.getResponseList().isEmpty()) {
			for (Cities city : cityList) {
				pincodeList = city.getPincodes();
				{
					for (Pincodes pincode : pincodeList) {
						responseDetails = baseAreaDetailsValidationService.validateBaseAreaDetails(pincode,
								responseDetails);
					}
				}
			}
		}
		
		if (responseDetails.getResponseList().isEmpty()) {
			responseDetails = baseAreaDetailsValidationService.validateUniqueBaseAreaDetails(state, responseDetails);
		}
		
		if (responseDetails.getResponseList().isEmpty()) {
			
			baseAreaOperationsService.addBaseArea(state);
			
			responseDetails.getResponseList().add(
					new ResponseDTO(ValidationConstants.SUCCESS_CODE, ValidationConstants.SUCCESS_CODE_MESSAGE));
		}
		return responseDetails;
	}

	@RequestMapping(value = "/getBaseAreas", method = RequestMethod.GET)
	public List<States> getBaseAreaDetails() {
		return baseAreaOperationsService.getBaseAreaDetails();
	}
}
