package com.codethreemultidatasource.project.db1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codethreemultidatasource.project.models.VehicleModel;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Long>{

	Optional<VehicleModel> findByVehicleRegNo(String vehicleRegNo);
	
}
