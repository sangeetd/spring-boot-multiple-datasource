package com.codethreemultidatasource.project.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "msttblvehicleassigngps", schema = "dblocator")
public class VehicleAssignGpsModel implements Serializable {

	private Long id;
	private Long vehicleId;
	private Long deviceId;
	
	private VehicleModel vehicleModel;
	
	private DeviceModel deviceModel;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "vehicleid")
	public Long getVehicleId() {
		return vehicleId;
	}
	
	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	@Column(name = "deviceid")
	public Long getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	@OneToOne(targetEntity = VehicleModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicleId", referencedColumnName = "vehicleId")
	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	@OneToOne(targetEntity = DeviceModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "deviceId", referencedColumnName = "deviceId")
	public DeviceModel getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(DeviceModel deviceModel) {
		this.deviceModel = deviceModel;
	}
	
	
}
