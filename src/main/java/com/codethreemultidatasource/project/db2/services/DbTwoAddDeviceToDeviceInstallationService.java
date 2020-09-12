package com.codethreemultidatasource.project.db2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codethreemultidatasource.project.db2.repositories.DbTwoAddDeviceToDeviceInstallationRepository;
import com.codethreemultidatasource.project.models.AddDeviceToDeviceInstallationModel;

@Service
public class DbTwoAddDeviceToDeviceInstallationService {

	@Autowired
	private DbTwoAddDeviceToDeviceInstallationRepository dbTwoAddDevToDevInstRepo;
	
	public Optional<AddDeviceToDeviceInstallationModel> findByUniqueId(String uniqueId){
		return this.dbTwoAddDevToDevInstRepo.findByUniqueId(uniqueId);
	}
	
	
}
