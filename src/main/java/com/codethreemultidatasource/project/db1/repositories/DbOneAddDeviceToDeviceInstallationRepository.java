package com.codethreemultidatasource.project.db1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codethreemultidatasource.project.models.AddDeviceToDeviceInstallationModel;

@Repository
public interface DbOneAddDeviceToDeviceInstallationRepository extends JpaRepository<AddDeviceToDeviceInstallationModel, Long>{

	Optional<AddDeviceToDeviceInstallationModel> findByUniqueId(String uniqueId);
	
}
