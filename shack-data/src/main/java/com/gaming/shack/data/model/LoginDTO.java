package com.gaming.shack.data.model;

import java.io.Serializable;

/**
 * The persistent class for the HLD_USER database table.
 * 
 */

public class LoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String passcode;

	public LoginDTO() {

	}
	public LoginDTO(String memIdOrEmailId,String Passcode){
		super();
		this.id = memIdOrEmailId;
		this.passcode = Passcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", passcode=" + passcode + "]";
	}
	

}