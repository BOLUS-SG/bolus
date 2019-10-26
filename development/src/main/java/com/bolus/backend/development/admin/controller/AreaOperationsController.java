package com.bolus.backend.development.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolus.backend.development.ErrorHandling.ResponseDTO;
import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.admin.model.Cities;
import com.bolus.backend.development.admin.model.GeoFencingAddress;
import com.bolus.backend.development.admin.model.GeoFencingPoints;
import com.bolus.backend.development.admin.model.ServiceableAreas;
import com.bolus.backend.development.admin.service.IAreaOperationsService;
import com.bolus.backend.development.validation.constants.ValidationConstants;
import com.bolus.backend.development.validation.service.IServiceableAreaDetailsValidationService;
import com.bolus.backend.development.validation.service.IServiceableGPDetailsValidationService;

@RestController
@RequestMapping("/admin/area")
public class AreaOperationsController {

	@Autowired
	IAreaOperationsService areaOperationsService;

	@Autowired
	IServiceableGPDetailsValidationService serviceableGPDetailsValidationService;

	@Autowired
	ResponseDetails responseDetails;

	@Autowired
	IServiceableAreaDetailsValidationService serviceableAreaDetailsValidationService;

	@RequestMapping(value = "/addServiceableArea", method = RequestMethod.POST)
	public ResponseDetails addServiceableArea(@RequestBody ServiceableAreas serviceableArea) {

		List<GeoFencingPoints> gpList = null;
		GeoFencingAddress gpAddress = null;

		responseDetails.getResponseList().clear();

		responseDetails = serviceableAreaDetailsValidationService.validateAreaDetails(serviceableArea, responseDetails);
		if (responseDetails.getResponseList().isEmpty()) {
			gpList = serviceableArea.getGeoFencingPoints();
			for (GeoFencingPoints gp : gpList) {
				responseDetails = serviceableAreaDetailsValidationService.validateAreaDetails(gp, responseDetails);
			}
		}
		if (responseDetails.getResponseList().isEmpty()) {
			for (GeoFencingPoints gp : gpList) {
				gpAddress = gp.getGfAddress();
				responseDetails = serviceableAreaDetailsValidationService.validateAreaDetails(gpAddress,
						responseDetails);
			}
		}
		if (responseDetails.getResponseList().isEmpty()) {
			responseDetails = serviceableAreaDetailsValidationService.validateUniqueAreaDetails(serviceableArea,
					responseDetails);
		}
		if (responseDetails.getResponseList().isEmpty()) {
			gpList = serviceableArea.getGeoFencingPoints();
			for (GeoFencingPoints gp : gpList) {
				responseDetails = serviceableGPDetailsValidationService.validateUniqueGPDetails(gp, responseDetails);
			}
		}
		if (responseDetails.getResponseList().isEmpty()) {

			areaOperationsService.addServiceableArea(serviceableArea);

			responseDetails.getResponseList()
					.add(new ResponseDTO(ValidationConstants.SUCCESS_CODE, ValidationConstants.SUCCESS_CODE_MESSAGE));
		}
		return responseDetails;
	}
}
