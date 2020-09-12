package com.codethreemultidatasource.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "msttbldevice", schema = "dblocator")
public class DeviceModel {

	private Long deviceId;
	private String uniqueId;
	
	@Id
	@Column(name = "deviceid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	
	@Column(name = "uniqueid")
	public String getUniqueId() {
		return uniqueId;
	}
	
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	
}
