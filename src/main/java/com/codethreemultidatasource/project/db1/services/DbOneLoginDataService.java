package com.codethreemultidatasource.project.db1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codethreemultidatasource.project.db1.repositories.DbOneLoginDataRepository;
import com.codethreemultidatasource.project.models.LoginDataModel;

@Service
public class DbOneLoginDataService {

	@Autowired
	private DbOneLoginDataRepository dbOneLoginDataRepo;
	
	public Optional<LoginDataModel> findByLoginId(Long id){
		return this.dbOneLoginDataRepo.findByLoginId(id);
	}
	
}
