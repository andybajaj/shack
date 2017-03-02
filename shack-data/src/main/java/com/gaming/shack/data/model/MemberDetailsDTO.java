package com.gaming.shack.data.model;

import java.util.List;

/**
 * The member details 
 * @author shahnawf
 *
 */
public class MemberDetailsDTO {
	
	private String faceBookId ; 
	private String profilePictureId ; 
	
	private List<OptInDTO> optIns ;
	
	private MemberAddressDTO mailAddress ; 
	
	private MemberAddressDTO billingAddress ;
	
	public String getFaceBookId() {
		return faceBookId;
	}

	public void setFaceBookId(String faceBookId) {
		this.faceBookId = faceBookId;
	}

	public String getProfilePictureId() {
		return profilePictureId;
	}

	public void setProfilePictureId(String profilePictureId) {
		this.profilePictureId = profilePictureId;
	}

	public List<OptInDTO> getOptIns() {
		return optIns;
	}

	public void setOptIns(List<OptInDTO> optIns) {
		this.optIns = optIns;
	}
	
	
	public MemberAddressDTO getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(MemberAddressDTO mailAddress) {
		this.mailAddress = mailAddress;
	}

	public MemberAddressDTO getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(MemberAddressDTO billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public String toString() {
		return "MemberDetailsDTO [faceBookId=" + faceBookId + ", profilePictureId=" + profilePictureId + ", optIns="
				+ optIns + ", mailAddress=" + mailAddress + ", billingAddress=" + billingAddress + "]";
	} 
	
	
}
