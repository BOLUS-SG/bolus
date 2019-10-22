package com.bolus.backend.development.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolus.backend.development.admin.dao.repository.IBaseAreaOperationsRepository;
import com.bolus.backend.development.admin.model.States;

@Service
public class BaseAreaOperationsService implements IBaseAreaOperationsService{
	
	@Autowired
	IBaseAreaOperationsRepository baseAreaOperationsRepository;
	
	@Override
	public States addBaseArea(States state) {
		return baseAreaOperationsRepository.save(state);
	}

	@Override
	public List<States> getBaseAreaDetails() {
		return baseAreaOperationsRepository.findAll();
	}

}
