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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bolus.backend.development.validation.model.BaseAreaValidationBean;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Cities")
public class Cities extends BaseAreaValidationBean{

	@Id
	@GeneratedValue
	private Integer id;
	@NotEmpty(message = "{location.city.invalid}")
	private String city;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	@NotNull(message = "{location.areas.invalid}")
	@Size(min = 1,message = "{location.areas.invalid.size}")
	private List<Areas> areas = new ArrayList<Areas>();
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	@NotNull(message = "{location.pincodes.invalid}")
	@Size(min = 1,message = "{location.pincodes.invalid.size}")
	private List<Pincodes> pincodes = new ArrayList<Pincodes>();
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="state_id")
	private States state;
	public Cities() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cities(Integer id, String city, List<Areas> areas, List<Pincodes> pincodes, States state) {
		super();
		this.id = id;
		this.city = city;
		this.areas = areas;
		this.pincodes = pincodes;
		this.state = state;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
