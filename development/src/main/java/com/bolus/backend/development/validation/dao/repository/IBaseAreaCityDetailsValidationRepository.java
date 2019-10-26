package com.bolus.backend.development.validation.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.Cities;

import com.bolus.backend.development.admin.model.Cities;

public interface IBaseAreaCityDetailsValidationRepository extends JpaRepository<Cities, Integer>{
	
	public boolean existsByCityIn(List<String> city);

}
