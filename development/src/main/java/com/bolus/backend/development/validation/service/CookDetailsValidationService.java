package com.bolus.backend.development.validation.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.bolus.backend.development.employee.model.Cook;
import com.bolus.backend.development.validation.dao.repository.ICookDetailsValidationRepository;

public class CookDetailsValidationService implements ICookDetailsValidationService{

	@Autowired
	ICookDetailsValidationRepository cookDetailsValidationRepository;
	
	@Override
	public Set<String> validateUniqueCookDetails(Cook cook) {
		return null;
	}
		
	}

