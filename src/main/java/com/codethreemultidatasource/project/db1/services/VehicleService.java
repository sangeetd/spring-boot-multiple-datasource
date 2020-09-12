package com.codethreemultidatasource.project.db1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codethreemultidatasource.project.db1.repositories.VehicleRepository;
import com.codethreemultidatasource.project.models.VehicleModel;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;
	
	public Optional<VehicleModel> findByVehicleRegNo(String vehicleRegNo){
		return this.vehicleRepo.findByVehicleRegNo(vehicleRegNo);
	}
	
	
}
