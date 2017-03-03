package com.gaming.shack.data.model;

import java.io.Serializable;

import com.gaming.shack.data.enums.MemberType;

/**
 * The JSON representation of the member profile 
 * being passed as API request
 * @author shahnawf
 *
 */
public class MemberProfileDTO implements Serializable {
		
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -1466861230858686070L;
	private String firstName ; 
	private String lastName ; 
	private String middleName ;
	private String nameTitle ;
	private String dateOfBirth ;
	private String emailId ;
	private String phoneNumberCountryCode ;
	private String phoneNumber ;
	private boolean leftHanded ;
	/**
	 * The SMID
	 */
	private long preferredSite ; 
	private long membershipType ; 
	private int memberType ;
	private String termConditionVersion ;
	private String encodedPassword ; 
	
	private long parentMemberId ;
	
	private MemberDetailsDTO memberDetails ;
	
	/**
	 * This will be moved to header later
	 */
	private long channelId ; 
	
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getNameTitle() {
		return nameTitle;
	}

	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumberCountryCode() {
		return phoneNumberCountryCode;
	}

	public void setPhoneNumberCountryCode(String phoneNumberCountryCode) {
		this.phoneNumberCountryCode = phoneNumberCountryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public boolean getLeftHanded() {
		return leftHanded;
	}

	public void setLeftHanded(boolean leftHanded) {
		this.leftHanded = leftHanded;
	}

	public long getPreferredSite() {
		return preferredSite;
	}

	public void setPreferredSite(long preferredSite) {
		this.preferredSite = preferredSite;
	}

	public long getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(long membershipType) {
		this.membershipType = membershipType;
	}

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}

	public String getTermConditionVersion() {
		return termConditionVersion;
	}

	public void setTermConditionVersion(String termConditionVersion) {
		this.termConditionVersion = termConditionVersion;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = encodedPassword;
	}

	public MemberDetailsDTO getMemberDetails() {
		return memberDetails;
	}

	public void setMemberDetails(MemberDetailsDTO memberDetails) {
		this.memberDetails = memberDetails;
	}
	
	
	public long getParentMemberId() {
		return parentMemberId;
	}

	public void setParentMemberId(long paremtMemberId) {
		this.parentMemberId = paremtMemberId;
	}
	
	
	public long getChannelId() {
		return channelId;
	}

	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}

	@Override
	public String toString() {
		return "MemberProfileDTO [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", nameTitle=" + nameTitle + ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId
				+ ", phoneNumberCountryCode=" + phoneNumberCountryCode + ", phoneNumber=" + phoneNumber
				+ ", isLeftHanded=" + leftHanded + ", preferredSite=" + preferredSite + ", membershipType="
				+ membershipType + ", memberType=" + memberType + ", termConditionVersion=" + termConditionVersion
				+ ", encodedPassword=" + encodedPassword + ", paremtMemberId=" + parentMemberId + ", memberDetails="
				+ memberDetails + "]";
	} 
	
	
	
}
