package com.bolus.backend.development.validation.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.States;

public interface IBaseAreaDetailsValidationRepository extends JpaRepository<States, Integer>{

	public boolean existsByState(String state);
}
