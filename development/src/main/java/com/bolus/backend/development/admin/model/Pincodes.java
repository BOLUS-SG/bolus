package com.bolus.backend.development.admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Pincodes")
public class Pincodes {

	@Id
	@GeneratedValue
	private int id;
	private String pincode;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private Cities cities;
	public Pincodes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pincodes(int id, String pincode, Cities cities) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.cities = cities;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Cities getCities() {
		return cities;
	}
	public void setCities(Cities cities) {
		this.cities = cities;
	}
	
	
}
