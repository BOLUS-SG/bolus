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
@Table(name="Areas")
public class Areas {

	@Id
	@GeneratedValue
	private Integer id;
	private String area;
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private Cities cities;
	public Areas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Areas(Integer id, String area, Cities cities) {
		super();
		this.id = id;
		this.area = area;
		this.cities = cities;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Cities getCities() {
		return cities;
	}
	public void setCities(Cities cities) {
		this.cities = cities;
	}
	
	
}
