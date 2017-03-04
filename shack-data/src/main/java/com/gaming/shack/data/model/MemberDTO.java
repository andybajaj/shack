package com.gaming.shack.data.model;

import java.io.Serializable;

/**
 * The JSON representation of the member profile 
 * being passed as API request
 * @author shahnawf
 *
 */
public class MemberDTO implements Serializable {
		
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -146686123085868604L;
	
	private MemberProfileDTO memberProfile ; 
	
	private MemberDetailsDTO memberDetails ;

	public MemberProfileDTO getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(MemberProfileDTO memberProfile) {
		this.memberProfile = memberProfile;
	}

	public MemberDetailsDTO getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(MemberDetailsDTO memberDetails) {
		this.memberDetails = memberDetails;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberProfile=" + memberProfile + ", memberDetails=" + memberDetails + "]";
	}
	
	
	
}
