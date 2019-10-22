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
	private int id;
	private int areaId;
	private int cityId;
	private int stateId;
	private int pincodeId;
	@OneToOne(mappedBy= "gfAddress", cascade=CascadeType.ALL)
	private GeoFencingPoints geoFencingPoints;
	public GeoFencingAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GeoFencingAddress(int id, int areaId, int cityId, int stateId, int pincodeId,
			GeoFencingPoints geoFencingPoints) {
		super();
		this.id = id;
		this.areaId = areaId;
		this.cityId = cityId;
		this.stateId = stateId;
		this.pincodeId = pincodeId;
		this.geoFencingPoints = geoFencingPoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getPincodeId() {
		return pincodeId;
	}
	public void setPincodeId(int pincodeId) {
		this.pincodeId = pincodeId;
	}

	public GeoFencingPoints getGeoFencingPoints() {
		return geoFencingPoints;
	}

	public void setGeoFencingPoints(GeoFencingPoints geoFencingPoints) {
		this.geoFencingPoints = geoFencingPoints;
	}
	
	
}
