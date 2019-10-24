package com.bolus.backend.development.employee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bolus.backend.development.validation.model.EmployeeValidationBean;



@Entity
@Table(name="Assigned_Areas")
public class AssignedArea extends EmployeeValidationBean{
	
	@Id
	@GeneratedValue
	private Integer id;
	@OneToMany(mappedBy="assignedArea")
	private List<Employee> employee;
	private Integer areaId;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="assigned_area_id",referencedColumnName = "id")
	private List<AssignedGeoFencingPoint> assignedGeoFencingPoints;
	public AssignedArea() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssignedArea(Integer id, List<Employee> employee, Integer areaId,
			List<AssignedGeoFencingPoint> assignedGeoFencingPoints) {
		super();
		this.id = id;
		this.employee = employee;
		this.areaId = areaId;
		this.assignedGeoFencingPoints = assignedGeoFencingPoints;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public List<AssignedGeoFencingPoint> getAssignedGeoFencingPoints() {
		return assignedGeoFencingPoints;
	}
	public void setAssignedGeoFencingPoints(List<AssignedGeoFencingPoint> assignedGeoFencingPoints) {
		this.assignedGeoFencingPoints = assignedGeoFencingPoints;
	}
	
	

}
