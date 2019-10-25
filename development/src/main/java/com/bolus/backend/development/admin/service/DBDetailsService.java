package com.bolus.backend.development.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolus.backend.development.admin.dao.repository.IDBDetailsRepository;
import com.bolus.backend.development.employee.model.DBSecondaryDetails;

@Service
public class DBDetailsService implements IDBDetailsService{

	@Autowired
	IDBDetailsRepository dbDetailsRepository;
	
	@Override
	public DBSecondaryDetails addDBSecondaryDetails(DBSecondaryDetails dBSecondaryDetails) {
		return dbDetailsRepository.save(dBSecondaryDetails);
	}

}
