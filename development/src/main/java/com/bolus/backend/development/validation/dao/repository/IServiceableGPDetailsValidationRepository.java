package com.bolus.backend.development.validation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.GeoFencingPoints;

public interface IServiceableGPDetailsValidationRepository extends JpaRepository<GeoFencingPoints, Integer>{
	
	public boolean existsByLatitude(String latitude);
	public boolean existsByLongitude(String longitude);

}
