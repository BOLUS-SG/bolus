package com.bolus.backend.development.admin.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolus.backend.development.admin.model.States;

public interface IBaseAreaOperationsRepository extends JpaRepository<States,Integer>{
	public States save(States states);
	public List<States> findAll();
}
