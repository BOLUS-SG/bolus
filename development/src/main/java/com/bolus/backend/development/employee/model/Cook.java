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

	public Cook(int id, String firstName, String lastName, Date dob, long phone, String email, long altPhone,
			String type, String aadharCard, List<Address> address) {
		super(id, firstName, lastName, dob, phone, email, altPhone, type, aadharCard, address);
		// TODO Auto-generated constructor stub
	}
	
}
