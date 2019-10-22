package com.bolus.backend.development.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolus.backend.development.admin.model.ServiceableAreas;
import com.bolus.backend.development.admin.service.IAreaOperationsService;

@RestController
@RequestMapping("/admin/area")
public class AreaOperationsController {

	@Autowired
	IAreaOperationsService areaOperationsService;
	
	@RequestMapping(value="/addServiceableArea", method=RequestMethod.POST)
	public ServiceableAreas addServiceableArea(@RequestBody ServiceableAreas serviceableArea) {
		return areaOperationsService.addServiceableArea(serviceableArea);
	}
}
