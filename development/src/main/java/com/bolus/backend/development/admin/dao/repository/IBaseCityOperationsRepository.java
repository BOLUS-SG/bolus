package com.bolus.backend.development.admin.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.Cities;

public interface IBaseCityOperationsRepository extends JpaRepository<Cities, Integer>{
	@Override
	public Cities save(Cities city);
}
