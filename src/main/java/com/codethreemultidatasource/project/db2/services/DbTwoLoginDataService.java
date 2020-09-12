package com.codethreemultidatasource.project.db2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codethreemultidatasource.project.db2.repositories.DbTwoLoginDataRepository;
import com.codethreemultidatasource.project.models.LoginDataModel;

@Service
public class DbTwoLoginDataService {

	@Autowired
	private DbTwoLoginDataRepository dbTwoLoginDataRepo;
	
	public Optional<LoginDataModel> findByLoginId(Long id){
		return this.dbTwoLoginDataRepo.findByLoginId(id);
	}
	
}

