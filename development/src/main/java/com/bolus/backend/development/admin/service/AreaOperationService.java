package com.bolus.backend.development.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolus.backend.development.admin.dao.repository.IAreaOperationsRepository;
import com.bolus.backend.development.admin.model.ServiceableAreas;

@Service
public class AreaOperationService implements IAreaOperationsService{
	
	@Autowired
	private IAreaOperationsRepository areaOperationsRepository;

	@Override
	public ServiceableAreas addServiceableArea(ServiceableAreas serviceableArea) {
		return areaOperationsRepository.save(serviceableArea);
	}

}
