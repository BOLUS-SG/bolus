package com.bolus.backend.development.admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.bolus.backend.development.validation.model.BaseAreaValidationBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Pincodes")
public class Pincodes extends BaseAreaValidationBean{

	@Id
	@GeneratedValue
	private Integer id;
	@NotEmpty(message = "{location.pincode.invalid}")
	private String pincode;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private Cities cities;
	public Pincodes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pincodes(Integer id, String pincode, Cities cities) {
		super();
		this.id = id;
		this.pincode = pincode;
		this.cities = cities;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
