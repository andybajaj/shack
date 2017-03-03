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
	private Long preferredSite ; 
	private int membershipType ; 
	private int memberType ;
	private String termConditionVersion ;
	private String encodedPassword ; 
	
	private Long parentMemberId ;
	
	private Long memberId ; 
	
	private MemberDetailsDTO memberDetails ;
	
	/**
	 * This will be moved to header later
	 */
	private Long channelId ; 
	
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

	public Long getPreferredSite() {
		return preferredSite;
	}

	public void setPreferredSite(Long preferredSite) {
		this.preferredSite = preferredSite;
	}

	public int getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(int membershipType) {
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
	
	
	public Long getParentMemberId() {
		return parentMemberId;
	}

	public void setParentMemberId(Long paremtMemberId) {
		this.parentMemberId = paremtMemberId;
	}
	
	
	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	
	
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "MemberProfileDTO [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", nameTitle=" + nameTitle + ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId
				+ ", phoneNumberCountryCode=" + phoneNumberCountryCode + ", phoneNumber=" + phoneNumber
				+ ", leftHanded=" + leftHanded + ", preferredSite=" + preferredSite + ", membershipType="
				+ membershipType + ", memberType=" + memberType + ", termConditionVersion=" + termConditionVersion
				+ ", encodedPassword=" + encodedPassword + ", parentMemberId=" + parentMemberId + ", memberId="
				+ memberId + ", memberDetails=" + memberDetails + ", channelId=" + channelId + "]";
	} 
	
	
	
}
