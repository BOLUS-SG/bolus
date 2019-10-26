package com.bolus.backend.development.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolus.backend.development.admin.dao.repository.IBaseCityOperationsRepository;
import com.bolus.backend.development.admin.model.Cities;

@Service
public class BaseCityOperationsService implements IBaseCityOperationsService{

	@Autowired
	IBaseCityOperationsRepository baseCityOperationsRepository;
	
	@Override
	public Cities addBaseCity(Cities city) {
		return baseCityOperationsRepository.save(city);
	}

}
