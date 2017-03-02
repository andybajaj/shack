package com.gaming.shack.data.model;

import java.util.Date;

import com.gaming.shack.data.enums.MembershipType;

/**
 * The JSON representation of the member profile 
 * being passed as API request
 * @author shahnawf
 *
 */
public class MemberProfileDTO {
	private String firstName ; 
	private String lastName ; 
	private String middleName ;
	private String nameTitle ;
	private Date dateOfBirth ;
	private String emailId ;
	private String phoneNumberCountryCode ;
	private String phoneNumber ;
	private boolean isLeftHanded ;
	/**
	 * The SMID
	 */
	private long preferredSite ; 
	private long membershipType ; 
	private MembershipType memberType ;
	private String termConditionVersion ;
	private String encodedPassword ; 
	
	private MemberDetailsDTO memberDetails ;

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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

	public boolean isLeftHanded() {
		return isLeftHanded;
	}

	public void setLeftHanded(boolean isLeftHanded) {
		this.isLeftHanded = isLeftHanded;
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

	public MembershipType getMemberType() {
		return memberType;
	}

	public void setMemberType(MembershipType memberType) {
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

	@Override
	public String toString() {
		return "MemberProfileDTO [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", nameTitle=" + nameTitle + ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId
				+ ", phoneNumberCountryCode=" + phoneNumberCountryCode + ", phoneNumber=" + phoneNumber
				+ ", isLeftHanded=" + isLeftHanded + ", preferredSite=" + preferredSite + ", membershipType="
				+ membershipType + ", memberType=" + memberType + ", termConditionVersion=" + termConditionVersion
				+ ", encodedPassword=" + encodedPassword + ", memberDetails=" + memberDetails + "]";
	} 
	
	
	
}
