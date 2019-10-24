package com.bolus.backend.development.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolus.backend.development.admin.model.Cities;
import com.bolus.backend.development.admin.model.States;
import com.bolus.backend.development.admin.service.IBaseAreaOperationsService;

@RestController
@RequestMapping("/admin/area/baseArea")
public class BaseAreaOperationsController {

	@Autowired
	IBaseAreaOperationsService baseAreaOperationsService;
	
	@RequestMapping(value="/addBaseArea", method=RequestMethod.POST)
	public States addBaseAreaDetails(@RequestBody States state) {
		return baseAreaOperationsService.addBaseArea(state);
	}
	
	@RequestMapping(value="/getBaseAreas", method=RequestMethod.GET)
	public List<States> getBaseAreaDetails() {
		return baseAreaOperationsService.getBaseAreaDetails();
	}
}
