package com.bolus.backend.development.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bolus.backend.development.validation.model.EmployeeValidationBean;



@Entity
@Table(name="assigned_geo_fencing_points")
public class AssignedGeoFencingPoint extends EmployeeValidationBean{

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn(name="assigned_area_id")
	private AssignedArea assignedArea;
	private Integer geoPointId;
	public AssignedGeoFencingPoint() {
		super();
	}
	public AssignedGeoFencingPoint(Integer id, AssignedArea assignedArea, Integer geoPointId) {
		super();
		this.id = id;
		this.assignedArea = assignedArea;
		this.geoPointId = geoPointId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public AssignedArea getAssignedArea() {
		return assignedArea;
	}
	public void setAssignedArea(AssignedArea assignedArea) {
		this.assignedArea = assignedArea;
	}
	public Integer getGeoPointId() {
		return geoPointId;
	}
	public void setGeoPointId(Integer geoPointId) {
		this.geoPointId = geoPointId;
	}
	
	
}
