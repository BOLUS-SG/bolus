package com.bolus.backend.development.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolus.backend.development.admin.model.Cities;
import com.bolus.backend.development.admin.model.States;
import com.bolus.backend.development.admin.service.IBaseCityOperationsService;

@RestController("/admin/area/baseCity")
public class BaseCityOperationsController {
	
	@Autowired
	IBaseCityOperationsService baseCityOperationsService;
	
	@RequestMapping(value="/addBaseCity", method=RequestMethod.POST)
	public Cities addBaseCityDetails(@RequestBody Cities city) {
		return baseCityOperationsService.addBaseCity(city);
	}
}
