package com.bolus.backend.development.validation.service;

import java.util.Set;

import com.bolus.backend.development.employee.model.Cook;

public interface ICookDetailsValidationService {

	public Set<String> validateUniqueCookDetails(Cook cook);
}
