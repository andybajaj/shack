package com.gaming.shack.data.model;

public class OptInDTO {
	private String optTypeId ; 
	private String status ;
	public String getOptTypeId() {
		return optTypeId;
	}
	public void setOptTypeId(String optTypeId) {
		this.optTypeId = optTypeId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OptInDTO [optTypeId=" + optTypeId + ", status=" + status + "]";
	}
	
	
}
