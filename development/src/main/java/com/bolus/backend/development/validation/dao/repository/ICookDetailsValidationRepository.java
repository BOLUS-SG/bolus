package com.bolus.backend.development.validation.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.employee.model.Cook;

public interface ICookDetailsValidationRepository extends JpaRepository<Cook, Integer>{
	
	public boolean existsByEmail(String email);
	public boolean existsByPhone(String phone);
	public boolean existsByAltPhone(String altPhone);
}
