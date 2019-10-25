package com.bolus.backend.development.validation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.employee.model.DBSecondaryDetails;

public interface IDBDetailsValidationRepository extends JpaRepository<DBSecondaryDetails, Integer>{

	public boolean existsByDrivingLicense(String drivingLicense);
}
