package com.codethreemultidatasource.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.codethreemultidatasource.project.db1.services.DbOneAddDeviceToDeviceInstallationService;
import com.codethreemultidatasource.project.db1.services.DbOneLoginDataService;
import com.codethreemultidatasource.project.db1.services.DeviceService;
import com.codethreemultidatasource.project.db1.services.VehicleAssignGpsService;
import com.codethreemultidatasource.project.db1.services.VehicleService;
import com.codethreemultidatasource.project.db2.services.DbTwoAddDeviceToDeviceInstallationService;
import com.codethreemultidatasource.project.db2.services.DbTwoLoginDataService;

@Component
public class ServiceRegistries {

	@Autowired
	private DbOneLoginDataService dbOneLoginDataService;
	
	@Autowired
	private DbOneAddDeviceToDeviceInstallationService dbOneAddDevToDevInstService;

	@Autowired
	private DbTwoAddDeviceToDeviceInstallationService dbTwoAddDevToDevInstService;

	@Autowired
	private DbTwoLoginDataService dbTwoLoginDataService;
	
	@Autowired
	private VehicleService dbOneVehicleService;
	
	@Autowired
	private DeviceService dbOneDeviceService;
	
	@Autowired
	private VehicleAssignGpsService dbOneVehicleAssignGpsService;
	
	@Bean
	public VehicleService getDbOneVehicleService() {
		return dbOneVehicleService;
	}

	@Bean
	public DeviceService getDbOneDeviceService() {
		return dbOneDeviceService;
	}

	@Bean
	public VehicleAssignGpsService getDbOneVehicleAssignGpsService() {
		return dbOneVehicleAssignGpsService;
	}

	@Bean
	public DbOneLoginDataService getDbOneLoginDataService() {
		return dbOneLoginDataService;
	}

	@Bean
	public DbOneAddDeviceToDeviceInstallationService getDbOneAddDevToDevInstService() {
		return dbOneAddDevToDevInstService;
	}

	@Bean
	public DbTwoAddDeviceToDeviceInstallationService getDbTwoAddDevToDevInstService() {
		return dbTwoAddDevToDevInstService;
	}

	@Bean
	public DbTwoLoginDataService getDbTwoLoginDataService() {
		return dbTwoLoginDataService;
	}
	
	
}
