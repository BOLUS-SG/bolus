package com.bolus.backend.development.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bolus.backend.development.ErrorHandling.ResponseDTO;
import com.bolus.backend.development.ErrorHandling.ResponseDetails;
import com.bolus.backend.development.admin.model.GeoFencingPoints;
import com.bolus.backend.development.admin.service.IDBDetailsService;
import com.bolus.backend.development.admin.service.IStaffOperationsService;
import com.bolus.backend.development.employee.model.AssignedGeoFencingPoint;
import com.bolus.backend.development.employee.model.DBSecondaryDetails;
import com.bolus.backend.development.employee.model.Employee;
import com.bolus.backend.development.validation.constants.ValidationConstants;
import com.bolus.backend.development.validation.service.IDBDetailsValidationService;
import com.bolus.backend.development.validation.service.IEmployeeDetailsValidationService;

@RestController
@RequestMapping("/admin/staff")
public class StaffOperationsController {

	@Autowired
	private IStaffOperationsService staffOperationsService;

	@Autowired
	IEmployeeDetailsValidationService employeeDetailsValidationService;

	@Autowired
	IDBDetailsValidationService dbDetailsValidationService;

	@Autowired
	IDBDetailsService dbDetailsService;

	@Autowired
	ResponseDetails responseDetails;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseDetails addEmployee(@RequestBody Employee employee) {

		responseDetails.getResponseList().clear();

		responseDetails = employeeDetailsValidationService.validateEmployeeDetails(employee, responseDetails);
		if (responseDetails.getResponseList().isEmpty()) {
			responseDetails = employeeDetailsValidationService.validateEmployeeDetails(employee.getAssignedArea(),
					responseDetails);
		}
		if (responseDetails.getResponseList().isEmpty()) {
			List<AssignedGeoFencingPoint> geoList = employee.getAssignedArea().getAssignedGeoFencingPoints();
				for(AssignedGeoFencingPoint geoPoint:geoList)
					responseDetails = employeeDetailsValidationService.validateEmployeeDetails(geoPoint,
							responseDetails);
		}
		if (responseDetails.getResponseList().isEmpty()) {
			responseDetails = employeeDetailsValidationService.validateUniqueDBDetails(employee, responseDetails);
		}

		if (responseDetails.getResponseList().isEmpty()) {
			staffOperationsService.addEmployeeService(employee);
			responseDetails.getResponseList()
					.add(new ResponseDTO(ValidationConstants.SUCCESS_CODE, ValidationConstants.SUCCESS_CODE_MESSAGE));
		}

		return responseDetails;
	}

	@RequestMapping(value = "/dbSecondaryDetails", method = RequestMethod.POST)
	public ResponseDetails addDBSecondaryDetails(@RequestBody DBSecondaryDetails dbSecondaryDetails) {

		responseDetails.getResponseList().clear();

		responseDetails = dbDetailsValidationService.validateDBDetails(dbSecondaryDetails, responseDetails);
		if (responseDetails.getResponseList().isEmpty()) {
			responseDetails = dbDetailsValidationService.validateUniqueDBDetails(dbSecondaryDetails, responseDetails);
		}
		if (responseDetails.getResponseList().isEmpty()) {
			Integer employeeId = null;
			try {
				employeeId = (staffOperationsService.getEmployeeIdByPhone(dbSecondaryDetails.getPhone())).getId();
			} catch (Exception exception) {
				responseDetails.getResponseList().add(new ResponseDTO(ValidationConstants.UNKNOWN_ERROR_CODE,
						ValidationConstants.UNKNOWN_ERROR_CODE_MESSAGE));
				return responseDetails;
			}

			dbSecondaryDetails.setEmployeeId(employeeId);

			if (responseDetails.getResponseList().isEmpty()) {
				dbDetailsService.addDBSecondaryDetails(dbSecondaryDetails);
				responseDetails.getResponseList().add(
						new ResponseDTO(ValidationConstants.SUCCESS_CODE, ValidationConstants.SUCCESS_CODE_MESSAGE));
			}

		}

		return responseDetails;
	}

	@RequestMapping(value = "/employeeList/{type}", method = RequestMethod.GET)
	public List<Employee> viewEmployeeList(@PathVariable("type") String type) {
		List<Employee> employeeList = staffOperationsService.getEmployeeList(type);
		return employeeList;
	}

}
