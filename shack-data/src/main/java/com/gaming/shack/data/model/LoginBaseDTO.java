package com.gaming.shack.data.model;

import java.io.Serializable;

/**
 * The persistent class for the HLD_USER database table.
 * 
 */

public class LoginBaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String id;

	
	public LoginBaseDTO() {

	}
	public LoginBaseDTO(String memIdOrEmailId){
		super();
		this.id = memIdOrEmailId;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "LoginDTO [id=" + id  + "]";
	}
	

}