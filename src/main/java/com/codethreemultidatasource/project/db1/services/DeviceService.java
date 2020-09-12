package com.codethreemultidatasource.project.db1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codethreemultidatasource.project.db1.repositories.DeviceRepository;
import com.codethreemultidatasource.project.models.DeviceModel;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository deviceRepo;
	
	public Optional<DeviceModel> findByUniqueId(String uniqueId){
		return this.deviceRepo.findByUniqueId(uniqueId);
	}
	
}
