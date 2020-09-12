package com.codethreemultidatasource.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "add_dev_inst", schema = "mobileapp")
public class AddDeviceToDeviceInstallationModel {


	private Long id;
	private String uniqueId;
	private String vehNo;
	
	public AddDeviceToDeviceInstallationModel() {
		super();
	}

	public AddDeviceToDeviceInstallationModel(Long id, String uniqueId, String vehNo) {
		super();
		this.id = id;
		this.uniqueId = uniqueId;
		this.vehNo = vehNo;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "imeino")
	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String iMEINO) {
		uniqueId = iMEINO;
	}

	@Column(name = "vehno")
	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}
	
	
	
}
