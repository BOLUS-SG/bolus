package com.bolus.backend.development.employee.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cook_details")
public class Cook extends Employee{

	public Cook() {
		super();
	}

	public Cook(Integer id, String firstName, String lastName, Date dob, Long phone, String email, Long altPhone,
			String type, String aadharCard, List<Address> address, AssignedArea assignedArea) {
		super(id, firstName, lastName, dob, phone, email, altPhone, type, aadharCard, address, assignedArea);
		// TODO Auto-generated constructor stub
	}

	
	
}
