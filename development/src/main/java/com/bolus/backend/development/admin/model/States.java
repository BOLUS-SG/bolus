package com.bolus.backend.development.admin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bolus.backend.development.validation.model.BaseAreaValidationBean;

@Entity
@Table(name="States")
public class States extends BaseAreaValidationBean{
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotEmpty(message = "{location.state.invalid}")
	private String state;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="state_id")
	@NotNull(message = "{location.cities.invalid}")
	@Size(min = 1,message = "{location.cities.invalid.size}")
	private List<Cities> cities = new ArrayList<Cities>();
	public States() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public States(Integer id, String state, List<Cities> cities) {
		super();
		this.id = id;
		this.state = state;
		this.cities = cities;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<Cities> getCities() {
		return cities;
	}
	public void setCities(List<Cities> cities) {
		this.cities = cities;
	}	
	
}
