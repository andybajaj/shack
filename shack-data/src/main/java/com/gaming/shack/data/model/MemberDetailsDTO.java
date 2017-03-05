package com.gaming.shack.data.model;

import java.io.Serializable;
import java.util.List;

/**
 * The member details 
 * @author shahnawf
 *
 */
public class MemberDetailsDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7150913610867793054L;
	
	private String faceBookId ; 
	private String profilePictureUri ;
	
	private List<OptInDTO> optInSelected ;
	
	private MemberAddressDTO mailAddress ; 
	
	private MemberAddressDTO billingAddress ;
	
	public String getFaceBookId() {
		return faceBookId;
	}

	public void setFaceBookId(String faceBookId) {
		this.faceBookId = faceBookId;
	}

	
	public String getProfilePictureUri() {
		return profilePictureUri;
	}

	public void setProfilePictureUri(String profilePictureUri) {
		this.profilePictureUri = profilePictureUri;
	}

	
	public List<OptInDTO> getOptInSelected() {
		return optInSelected;
	}

	public void setOptInSelected(List<OptInDTO> optInSelected) {
		this.optInSelected = optInSelected;
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
		return "MemberDetailsDTO [faceBookId=" + faceBookId + ", profilePictureUri=" + profilePictureUri + ", optInSelected="
				+ optInSelected + ", mailAddress=" + mailAddress + ", billingAddress=" + billingAddress + "]";
	} 
	
	
}
