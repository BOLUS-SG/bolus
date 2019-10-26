package com.bolus.backend.development.validation.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.Pincodes;

public interface IBaseAreaPincodeDetailsValidationRepository extends JpaRepository<Pincodes, Integer>{
	
	public boolean existsByPincode(List<String> pincode);

}
