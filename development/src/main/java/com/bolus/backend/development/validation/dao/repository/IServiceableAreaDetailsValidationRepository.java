package com.bolus.backend.development.validation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.ServiceableAreas;

public interface IServiceableAreaDetailsValidationRepository extends JpaRepository<ServiceableAreas, Integer>{

	public boolean existsByName(String name);
}
