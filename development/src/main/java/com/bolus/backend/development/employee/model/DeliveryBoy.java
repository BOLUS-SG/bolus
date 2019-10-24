package com.bolus.backend.development.employee.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "db_details")
public class DeliveryBoy extends Employee {

	private String drivingLicense;

	public DeliveryBoy() {
		super();
	}
	

	public DeliveryBoy(Integer id, String firstName, String lastName, Date dob, Long phone, String email, Long altPhone,
			String type, String aadharCard, List<Address> address, AssignedArea assignedArea) {
		super(id, firstName, lastName, dob, phone, email, altPhone, type, aadharCard, address, assignedArea);
	}


	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

}
