package com.codethreemultidatasource.project.db2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codethreemultidatasource.project.models.LoginDataModel;

@Repository
public interface DbTwoLoginDataRepository extends JpaRepository<LoginDataModel, Long>{

	Optional<LoginDataModel> findByLoginId(Long id);
	
}
