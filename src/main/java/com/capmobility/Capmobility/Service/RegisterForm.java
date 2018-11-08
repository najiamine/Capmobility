package com.capmobility.Capmobility.Service;

import java.util.Date;

public class RegisterForm {

	private String username;
	private String password;
	private String repassword;
	private Date dateIntegrationCap;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public Date getDateIntegrationCap() {
		return dateIntegrationCap;
	}

	public void setDateIntegrationCap(Date dateIntegrationCap) {
		this.dateIntegrationCap = dateIntegrationCap;
	}

}
