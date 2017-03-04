package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the MemberMaster_AUD database table.
 * 
 */
@Entity
@Table(name="MemberMaster_AUD")
@NamedQuery(name="MemberMaster_AUD.findAll", query="SELECT m FROM MemberMaster_AUD m")
public class MemberMaster_AUD implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MMAUDID",insertable=false,updatable=false)
	private Long mmaudid;

	@Column(name="CardBarCode")
	private Long cardBarCode;

	@Column(name="ChannelID")
	private Long channelID;

	@Column(name="CreateBy")
	private String createBy;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Temporal(TemporalType.DATE)
	@Column(name="DateOfBirth")
	private Date dateOfBirth;

	@Column(name="Emailaddress")
	private String emailaddress;

	@Column(name="GivenName")
	private String givenName;

	@Column(name="MemberID")
	private Long memberID;

	@Column(name="MembershipTypeID")
	private Long membershipTypeID;

	@Column(name="MemberStatus")
	private String memberStatus;

	@Column(name="MemberTypeID")
	private Long memberTypeID;

	@Column(name="MiddleName")
	private String middleName;

	@Column(name="MobileBarCodeURI")
	private String mobileBarCodeURI;

	@Column(name="NameTitle")
	private String nameTitle;

	@Column(name="ParentMemberID")
	private Long parentMemberID;

	@Column(name="ProfilePictureURI")
	private String profilePictureURI;

	@Column(name="SiteID")
	private Long siteID;

	@Column(name="SocialmediaID")
	private Long socialmediaID;

	@Column(name="Surname")
	private String surname;

	private Long TCTemplateID;

	@Column(name="TelephoneCountryCode")
	private String telephoneCountryCode;

	@Column(name="TelephoneNumber")
	private String telephoneNumber;

	@Column(name="UpdateBy")
	private String updateBy;

	@Column(name="UpdateDate")
	private Timestamp updateDate;

	//bi-directional many-to-one association to MemberMaster
	@ManyToOne()
	@JoinColumn(name="MMID")
	private MemberMaster memberMaster;

	public MemberMaster_AUD() {
	}

	public Long getMmaudid() {
		return this.mmaudid;
	}

	public void setMmaudid(Long mmaudid) {
		this.mmaudid = mmaudid;
	}

	public Long getCardBarCode() {
		return this.cardBarCode;
	}

	public void setCardBarCode(Long cardBarCode) {
		this.cardBarCode = cardBarCode;
	}

	public Long getChannelID() {
		return this.channelID;
	}

	public void setChannelID(Long channelID) {
		this.channelID = channelID;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailaddress() {
		return this.emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getGivenName() {
		return this.givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public Long getMemberID() {
		return this.memberID;
	}

	public void setMemberID(Long memberID) {
		this.memberID = memberID;
	}

	public Long getMembershipTypeID() {
		return this.membershipTypeID;
	}

	public void setMembershipTypeID(Long membershipTypeID) {
		this.membershipTypeID = membershipTypeID;
	}

	public String getMemberStatus() {
		return this.memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public Long getMemberTypeID() {
		return this.memberTypeID;
	}

	public void setMemberTypeID(Long memberTypeID) {
		this.memberTypeID = memberTypeID;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileBarCodeURI() {
		return this.mobileBarCodeURI;
	}

	public void setMobileBarCodeURI(String mobileBarCodeURI) {
		this.mobileBarCodeURI = mobileBarCodeURI;
	}

	public String getNameTitle() {
		return this.nameTitle;
	}

	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}

	public Long getParentMemberID() {
		return this.parentMemberID;
	}

	public void setParentMemberID(Long parentMemberID) {
		this.parentMemberID = parentMemberID;
	}

	public String getProfilePictureURI() {
		return this.profilePictureURI;
	}

	public void setProfilePictureURI(String profilePictureURI) {
		this.profilePictureURI = profilePictureURI;
	}

	public Long getSiteID() {
		return this.siteID;
	}

	public void setSiteID(Long siteID) {
		this.siteID = siteID;
	}

	public Long getSocialmediaID() {
		return this.socialmediaID;
	}

	public void setSocialmediaID(Long socialmediaID) {
		this.socialmediaID = socialmediaID;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getTCTemplateID() {
		return this.TCTemplateID;
	}

	public void setTCTemplateID(Long TCTemplateID) {
		this.TCTemplateID = TCTemplateID;
	}

	public String getTelephoneCountryCode() {
		return this.telephoneCountryCode;
	}

	public void setTelephoneCountryCode(String telephoneCountryCode) {
		this.telephoneCountryCode = telephoneCountryCode;
	}

	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public MemberMaster getMemberMaster() {
		return this.memberMaster;
	}

	public void setMemberMaster(MemberMaster memberMaster) {
		this.memberMaster = memberMaster;
	}

}