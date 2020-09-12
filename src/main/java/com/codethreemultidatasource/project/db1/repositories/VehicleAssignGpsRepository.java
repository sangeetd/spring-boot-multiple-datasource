package com.codethreemultidatasource.project.db1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codethreemultidatasource.project.models.VehicleAssignGpsModel;

@Repository
public interface VehicleAssignGpsRepository extends JpaRepository<VehicleAssignGpsModel, Long>{

	public Optional<VehicleAssignGpsModel> findById(Long id);
	public Optional<VehicleAssignGpsModel> findByVehicleId(Long vehicleId);
	
	@Query(value = " select vgs.id, vgs.vehicleid, vgs.deviceid from dblocator.msttblvehicle as v\r\n" + 
			"inner join dblocator.msttblvehicleassigngps as vgs on vgs.vehicleid=v.vehicleid\r\n" + 
			"inner join dblocator.msttbldevice as d on d.deviceid=vgs.deviceid\r\n" + 
			"where case when (:searchParam != '') then \r\n" + 
			"v.vehicleregno=:searchParam or d.uniqueid=:searchParam else vgs.flag=0 end ", 
			nativeQuery=true)
	public Optional<VehicleAssignGpsModel> findVehicleDeviceMappingNativeQuery(@Param(value = "searchParam") String searchParam);
	
}
