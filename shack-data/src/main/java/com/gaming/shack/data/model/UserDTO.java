package com.gaming.shack.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the HLD_USER database table.
 * 
 */

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	

	
	
	private String emailAddress;

	
	private String firstName;

	
	private String lastName;

	
	private String password;

	

	@Column(name="userName")
	private String userName;

	

	public UserDTO() {
	}



	



	



	public UserDTO(String emailAddress, String firstName, String lastName, String password, String userName) {
		super();
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userName = userName;
	}











	public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}

}