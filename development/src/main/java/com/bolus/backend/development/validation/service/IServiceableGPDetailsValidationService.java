package com.bolus.backend.development.validation.service;

import java.util.Set;

import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.admin.model.GeoFencingPoints;
import com.bolus.backend.development.admin.model.States;

public interface IServiceableGPDetailsValidationService {
	
	public ResponseDetails validateUniqueGPDetails(GeoFencingPoints geoFencingPoint, ResponseDetails responseDetails);

	public ResponseDetails getUniqueResponseDetails(Set<String> responseCodeSet, ResponseDetails responseDetails);

}
