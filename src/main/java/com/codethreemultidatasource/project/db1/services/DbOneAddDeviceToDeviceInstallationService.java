package com.codethreemultidatasource.project.db1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codethreemultidatasource.project.db1.repositories.DbOneAddDeviceToDeviceInstallationRepository;
import com.codethreemultidatasource.project.models.AddDeviceToDeviceInstallationModel;

@Service
public class DbOneAddDeviceToDeviceInstallationService {

	@Autowired
	private DbOneAddDeviceToDeviceInstallationRepository dbOneAddDevToDevInstRepo;
	
	public Optional<AddDeviceToDeviceInstallationModel> findByUniqueId(String uniqueId){
		return this.dbOneAddDevToDevInstRepo.findByUniqueId(uniqueId);
	}
	
	
}
