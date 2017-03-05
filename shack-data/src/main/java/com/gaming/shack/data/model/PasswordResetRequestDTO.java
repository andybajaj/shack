package com.gaming.shack.data.model;

public class PasswordResetRequestDTO extends LoginDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2674207839449133475L;
	private String trackingID;

	public String getTrackingID() {
		return trackingID;
	}

	public void setTrackingID(String trackingID) {
		this.trackingID = trackingID;
	}

	@Override
	public String toString() {
		return "PasswordResetRequestDTO [trackingID=" + trackingID + ", id=" + id + "]";
	}
}
