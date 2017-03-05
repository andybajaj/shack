package com.gaming.shack.data.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class BasicMemberProfileDTO implements Serializable {
		
	@Override
	public String toString() {
		return "BasicMemberProfileDTO [memberId=" + memberId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", nameTitle=" + nameTitle + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", leftHanded=" + leftHanded + ", preferredSite=" + preferredSite + ", membershipType="
				+ membershipType + ", memberType=" + memberType + ", memberSince=" + memberSince + ", parentMemberId="
				+ parentMemberId + "]";
	}

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -1466861230858686070L;
	private Long memberId ; 
	private String firstName ; 
	private String lastName ; 
	private String middleName ;
	private String nameTitle ;
	
	private String emailId ;
	private String phoneNumber ;
	private boolean leftHanded ;
	/**
	 * The SMID
	 */
	private String preferredSite ; 
	private String membershipType ; 
	private String memberType ;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date memberSince ;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date membershipExpiryDate ;
	
	
	
	private Long parentMemberId ;
	
	
	
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isLeftHanded() {
		return leftHanded;
	}

	public void setLeftHanded(boolean leftHanded) {
		this.leftHanded = leftHanded;
	}

	public String getPreferredSite() {
		return preferredSite;
	}

	public void setPreferredSite(String preferredSite) {
		this.preferredSite = preferredSite;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Long getParentMemberId() {
		return parentMemberId;
	}

	public void setParentMemberId(Long parentMemberId) {
		this.parentMemberId = parentMemberId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public Date getMemberSince() {
		return memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public Date getMembershipExpiryDate() {
		return membershipExpiryDate;
	}

	public void setMembershipExpiryDate(Date membershipExpiryDate) {
		this.membershipExpiryDate = membershipExpiryDate;
	}

	
			
	
	
	
	
	
	
}
