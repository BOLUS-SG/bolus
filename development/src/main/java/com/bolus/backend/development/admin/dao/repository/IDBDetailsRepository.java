package com.bolus.backend.development.admin.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.employee.model.DBSecondaryDetails;

public interface IDBDetailsRepository extends JpaRepository<DBSecondaryDetails, Integer>{
	
	public DBSecondaryDetails save(DBSecondaryDetails dbSecondaryDetails);
}
