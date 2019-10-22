package com.bolus.backend.development.admin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Cities")
public class Cities {

	@Id
	@GeneratedValue
	private int id;
	private String city;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private List<Areas> areas = new ArrayList<Areas>();
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private List<Pincodes> pincodes = new ArrayList<Pincodes>();
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="state_id")
	private States state;
	public Cities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cities(int id, String city, List<Areas> areas, List<Pincodes> pincodes, States state) {
		super();
		this.id = id;
		this.city = city;
		this.areas = areas;
		this.pincodes = pincodes;
		this.state = state;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Areas> getAreas() {
		return areas;
	}
	public void setAreas(List<Areas> areas) {
		this.areas = areas;
	}

	public List<Pincodes> getPincodes() {
		return pincodes;
	}

	public void setPincodes(List<Pincodes> pincodes) {
		this.pincodes = pincodes;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}
	
	
}
