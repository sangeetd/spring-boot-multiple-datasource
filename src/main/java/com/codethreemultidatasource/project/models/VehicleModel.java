package com.codethreemultidatasource.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "msttblvehicle", schema = "dblocator")
public class VehicleModel {

	private Long vehicleId;
	private String vehicleRegNo;
	
	public VehicleModel() {
		super();
	}

	@Id
	@Column(name = "vehicleid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(name = "vehicleregno")
	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public void setVehicleRegNo(String vehicleRegNo) {
		this.vehicleRegNo = vehicleRegNo;
	}

}
