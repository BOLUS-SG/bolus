package com.bolus.backend.development.admin.service;

import java.util.List;

import com.bolus.backend.development.admin.model.ServiceableAreas;
import com.bolus.backend.development.admin.model.States;

public interface IBaseAreaOperationsService {
	public States addBaseArea(States state);
	public List<States> getBaseAreaDetails();
}
