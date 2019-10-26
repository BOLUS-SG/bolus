package com.bolus.backend.development.validation.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.Areas;

public interface IBaseAreaAreaDetailsValidationRepository extends JpaRepository<Areas, Integer>{

	public boolean existsByAreaIn(List<String> city);
}
