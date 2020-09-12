package com.codethreemultidatasource.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codethreemultidatasource.project.db1.services.DbOneAddDeviceToDeviceInstallationService;
import com.codethreemultidatasource.project.db1.services.DbOneLoginDataService;
import com.codethreemultidatasource.project.db2.services.DbTwoAddDeviceToDeviceInstallationService;
import com.codethreemultidatasource.project.db2.services.DbTwoLoginDataService;
import com.codethreemultidatasource.project.models.AddDeviceToDeviceInstallationModel;
import com.codethreemultidatasource.project.models.DeviceModel;
import com.codethreemultidatasource.project.models.LoginDataModel;
import com.codethreemultidatasource.project.models.VehicleAssignGpsModel;
import com.codethreemultidatasource.project.models.VehicleModel;
import com.codethreemultidatasource.project.services.ServiceRegistries;

@RestController
@RequestMapping("api/v1")
public class APIController {

	@Autowired
	private ServiceRegistries serviceRegistries;
	
	@GetMapping("test/{testString}")
	public String testAPI(@PathVariable("testString") String testString) {
		return testString;
	}
	
	@GetMapping("findByUniqueIdByDb1/{uniqueId}")
	public AddDeviceToDeviceInstallationModel findByUniqueIdByDb1(@PathVariable("uniqueId") String uniqueId) {
		return serviceRegistries.getDbOneAddDevToDevInstService().findByUniqueId(uniqueId).orElseThrow(() -> new RuntimeException("UniqueId not found from db1 repo..."));
	}
	
	
	@GetMapping("findByUniqueIdByDb2/{uniqueId}")
	public AddDeviceToDeviceInstallationModel findByUniqueIdByDb2(@PathVariable("uniqueId") String uniqueId) {
		return serviceRegistries.getDbTwoAddDevToDevInstService().findByUniqueId(uniqueId).orElseThrow(() -> new RuntimeException("UniqueId not found from db2 repo..."));
	}
	
	
	@GetMapping("findByLoginIdByDb1/{loginId}")
	public LoginDataModel findByLoginIdByDb1(@PathVariable("loginId") Long loginId) {
		return serviceRegistries.getDbOneLoginDataService().findByLoginId(loginId).orElseThrow(() -> new RuntimeException("LoginId not found from db1 repo..."));
	}
	
	
	@GetMapping("findByLoginIdByDb2/{loginId}")
	public LoginDataModel findByLoginIdByDb2(@PathVariable("loginId") Long loginId) {
		return serviceRegistries.getDbTwoLoginDataService().findByLoginId(loginId).orElseThrow(() -> new RuntimeException("LoginId not found from db2 repo..."));
	}
	
	
	@GetMapping("findByVehicleRegNoDb1/{vehicleRegNo}")
	public VehicleModel findByVehicleRegNoDb1(@PathVariable("vehicleRegNo") String vehicleRegNo) {
		return serviceRegistries.getDbOneVehicleService().findByVehicleRegNo(vehicleRegNo).orElseThrow(() -> new RuntimeException("Vehicle not found from db1 repo..."));
	}

	@GetMapping("findByUniqueIdDb1/{uniqueId}")
	public DeviceModel findByUniqueIdDb1(@PathVariable("uniqueId") String uniqueId) {
		return serviceRegistries.getDbOneDeviceService().findByUniqueId(uniqueId).orElseThrow(() -> new RuntimeException("Unique IMEI No not found from db1 repo..."));
	}
	
	@GetMapping("findVehicleMappingByVehicleRegNoDb1/{vehicleRegNo}")
	public VehicleAssignGpsModel findVehicleMappingByVehicleRegNoDb1(@PathVariable("vehicleRegNo") String vehicleRegNo) {
		//both style will work
		//VehicleModel vehicle=serviceRegistries.getDbOneVehicleService().findByVehicleRegNo(vehicleRegNo).orElseThrow(() -> new RuntimeException("Vehicle not found from db1 repo..."));
		VehicleModel vehicle=findByVehicleRegNoDb1(vehicleRegNo);
		Long vehicleId=vehicle.getVehicleId();
		return serviceRegistries.getDbOneVehicleAssignGpsService().findByVehicleId(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle Mapping not found from db1 repo..."));
	}
	
	@GetMapping("findVehicleDeviceMappingNativeQueryDb1/{vehicleRegNo}")
	public VehicleAssignGpsModel findVehicleDeviceMappingNativeQueryDb1(@PathVariable("vehicleRegNo") String vehicleRegNo) {
		return serviceRegistries.getDbOneVehicleAssignGpsService().findVehicleDeviceMappingNativeQuery(vehicleRegNo).orElseThrow(() -> new RuntimeException("Vehicle-Device Mapping not found from db1 repo and Native Join Query..."));
	}
	
	
}
