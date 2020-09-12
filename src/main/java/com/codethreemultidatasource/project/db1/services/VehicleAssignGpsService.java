package com.codethreemultidatasource.project.db1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codethreemultidatasource.project.db1.repositories.VehicleAssignGpsRepository;
import com.codethreemultidatasource.project.models.VehicleAssignGpsModel;

@Service
public class VehicleAssignGpsService {

	@Autowired
	private VehicleAssignGpsRepository vehicleAssignGpsRepo;
	
	public Optional<VehicleAssignGpsModel> findById(Long id){
		return this.vehicleAssignGpsRepo.findById(id);
	}
	
	public Optional<VehicleAssignGpsModel> findByVehicleId(Long vehicleId){
		return this.vehicleAssignGpsRepo.findByVehicleId(vehicleId);
	}
	
	public Optional<VehicleAssignGpsModel> findVehicleDeviceMappingNativeQuery(String searchParam){
		return this.vehicleAssignGpsRepo.findVehicleDeviceMappingNativeQuery(searchParam);
	}
	
}
