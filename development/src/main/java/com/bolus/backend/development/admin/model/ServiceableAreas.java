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

import com.bolus.backend.development.validation.model.ServiceableAreaValidationBean;

@Entity
@Table(name="Serviceable_Areas")
public class ServiceableAreas extends ServiceableAreaValidationBean{
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotEmpty(message = "{serviceableArea.name.invalid}")
	private String name;
	@NotEmpty(message = "{serviceableArea.maxLatitude.invalid}")
	private String maxLatitude;
	@NotEmpty(message = "{serviceableArea.minLatitude.invalid}")
	private String minLatitude;
	@NotEmpty(message = "{serviceableArea.maxLongitude.invalid}")
	private String maxLongitude;
	@NotEmpty(message = "{serviceableArea.minLatitude.invalid}")
	private String minLongitude;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name="area_id")
	@NotNull(message = "{serviceableArea.gp.invalid}")
	@Size(min = 1,message = "{serviceableArea.gp.invalid.size}")
	private List<GeoFencingPoints> geoFencingPoints = new ArrayList<GeoFencingPoints>();
	public ServiceableAreas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ServiceableAreas(Integer id, String name, String maxLatitude, String minLatitude, String maxLongitude,
			String minLongitude, List<GeoFencingPoints> geoFencingPoints) {
		super();
		this.id = id;
		this.name = name;
		this.maxLatitude = maxLatitude;
		this.minLatitude = minLatitude;
		this.maxLongitude = maxLongitude;
		this.minLongitude = minLongitude;
		this.geoFencingPoints = geoFencingPoints;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public List<GeoFencingPoints> getGeoFencingPoints() {
		return geoFencingPoints;
	}



	public void setGeoFencingPoints(List<GeoFencingPoints> geoFencingPoints) {
		this.geoFencingPoints = geoFencingPoints;
	}

	public String getMaxLatitude() {
		return maxLatitude;
	}

	public void setMaxLatitude(String maxLatitude) {
		this.maxLatitude = maxLatitude;
	}

	public String getMinLatitude() {
		return minLatitude;
	}

	public void setMinLatitude(String minLatitude) {
		this.minLatitude = minLatitude;
	}

	public String getMaxLongitude() {
		return maxLongitude;
	}

	public void setMaxLongitude(String maxLongitude) {
		this.maxLongitude = maxLongitude;
	}

	public String getMinLongitude() {
		return minLongitude;
	}

	public void setMinLongitude(String minLongitude) {
		this.minLongitude = minLongitude;
	}
		
}
