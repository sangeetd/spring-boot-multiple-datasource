package com.codethreemultidatasource.project.db1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codethreemultidatasource.project.models.DeviceModel;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceModel, Long>{

	Optional<DeviceModel> findByUniqueId(String uniqueId);
	
}
