package com.gaming.shack.data.model;

public class LoginResponse {

	private String sessionID;

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String transactionID) {
		this.sessionID = transactionID;
	}

	@Override
	public String toString() {
		return "LoginResponse [sessionID=" + sessionID + "]";
	}
	
	
}
