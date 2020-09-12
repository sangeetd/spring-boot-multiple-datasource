package com.codethreemultidatasource.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "msttbluserlogin", schema = "dblocator")
public class LoginDataModel {
	
	private Long loginId;
	private String loginName;
	private String password;
	
	public LoginDataModel() {
		super();
	}

	public LoginDataModel(Long loginId, String loginName, String password) {
		super();
		this.loginId = loginId;
		this.loginName = loginName;
		this.password = password;
	}

	@Id
	@Column(name = "loginid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	@Column(name = "loginname")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
	

}
