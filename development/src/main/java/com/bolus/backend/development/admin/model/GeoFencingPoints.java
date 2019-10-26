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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bolus.backend.development.validation.model.ServiceableAreaValidationBean;

@Entity
@Table(name="Geo_Fencing_Points")
public class GeoFencingPoints extends ServiceableAreaValidationBean{

	@Id
	@GeneratedValue
	private Integer id;
	@NotEmpty(message = "{serviceableGP.latitude.invalid}")
	private String latitude;
	@NotEmpty(message = "{serviceableGP.longitude.invalid}")
	private String longitude;
	@NotEmpty(message = "{serviceableGP.name.invalid}")
	private String name;
	@NotEmpty(message = "{serviceableGP.type.invalid}")
	private String type;
	@OneToOne(cascade = CascadeType.ALL)
	@NotNull(message = "{serviceableGP.address.invalid}")
	private GeoFencingAddress gfAddress;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="area_id")
	private ServiceableAreas serviceableAreas;
	public GeoFencingPoints() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public GeoFencingPoints(Integer id, String latitude, String longitude, String name, String type,
			GeoFencingAddress gfAddress, ServiceableAreas serviceableAreas) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.type = type;
		this.gfAddress = gfAddress;
		this.serviceableAreas = serviceableAreas;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public GeoFencingAddress getGfAddress() {
		return gfAddress;
	}


	public void setGfAddress(GeoFencingAddress gfAddress) {
		this.gfAddress = gfAddress;
	}


	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public ServiceableAreas getServiceableAreas() {
		return serviceableAreas;
	}


	public void setServiceableAreas(ServiceableAreas serviceableAreas) {
		this.serviceableAreas = serviceableAreas;
	}	
	
}
