package com.gaming.shack.data.entity.registration;

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
@Entity
@Table(name="user", schema="shack")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Integer id;

	

	
	@Column(name="emailAddress")
	private String emailAddress;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@Column(name="password")
	private String password;

	

	@Column(name="userName")
	private String userName;

	

	public User() {
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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