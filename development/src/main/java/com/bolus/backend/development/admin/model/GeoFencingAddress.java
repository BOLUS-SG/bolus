package com.bolus.backend.development.admin.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Geo_Fencing_Address")
public class GeoFencingAddress {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer areaId;
	private Integer cityId;
	private Integer stateId;
	private Integer pincodeId;
	@OneToOne(mappedBy= "gfAddress", cascade=CascadeType.ALL)
	private GeoFencingPoints geoFencingPoints;
	public GeoFencingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GeoFencingAddress(Integer id, Integer areaId, Integer cityId, Integer stateId, Integer pincodeId,
			GeoFencingPoints geoFencingPoints) {
		super();
		this.id = id;
		this.areaId = areaId;
		this.cityId = cityId;
		this.stateId = stateId;
		this.pincodeId = pincodeId;
		this.geoFencingPoints = geoFencingPoints;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getPincodeId() {
		return pincodeId;
	}
	public void setPincodeId(Integer pincodeId) {
		this.pincodeId = pincodeId;
	}

	public GeoFencingPoints getGeoFencingPoints() {
		return geoFencingPoints;
	}

	public void setGeoFencingPoints(GeoFencingPoints geoFencingPoints) {
		this.geoFencingPoints = geoFencingPoints;
	}
	
	
}
