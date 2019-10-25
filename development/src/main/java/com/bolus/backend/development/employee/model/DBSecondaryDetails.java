package com.bolus.backend.development.employee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bolus.backend.development.validation.model.EmployeeValidationBean;

@Entity
@Table(name="DB_Secondary_Details")
public class DBSecondaryDetails extends EmployeeValidationBean{
	
	@Id
	@GeneratedValue
	private Integer id;
	@Transient
	@NotNull(message = "{employee.phone.invalid}")
	private Long phone;
	private Integer employeeId;
	@NotEmpty(message = "{employee.dl.invalid}")
	private String drivingLicense;
	public DBSecondaryDetails() {
		super();
	}
	public DBSecondaryDetails(Integer id, Long phone, Integer employeeId, String drivingLicense) {
		super();
		this.id = id;
		this.phone = phone;
		this.employeeId = employeeId;
		this.drivingLicense = drivingLicense;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
}
