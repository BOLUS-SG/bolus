package com.bolus.backend.development.admin.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.ServiceableAreas;

public interface IAreaOperationsRepository extends JpaRepository<ServiceableAreas, Integer>{
	
	public ServiceableAreas save(ServiceableAreas serviceableArea);
}
