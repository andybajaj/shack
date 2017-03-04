package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;


/**
 * The persistent class for the MemberMaster database table.
 * 
 */
@Entity
@Table(name="MemberMaster")
@DynamicUpdate
@NamedQuery(name="MemberMaster.findAll", query="SELECT m FROM MemberMaster m")
public class MemberMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MMID")
	private Long mmid;

	@Column(name="CardBarCode")
	private Long cardBarCode;

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

//	@Column(name="MembershipTypeID")
//	private Long membershipTypeID;

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

	//bi-directional many-to-one association to MemberMaster_AUD
	@OneToMany(mappedBy="memberMaster"  , fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	private List<MemberMaster_AUD> memberMasterAuds;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="memberMaster" , fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	private List<Address> addresses;

	//bi-directional many-to-one association to MemberActivation
	@OneToMany(mappedBy="memberMaster")
	private List<MemberActivation> memberActivations;

	//bi-directional many-to-one association to Channel
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	@JoinColumn(name="CLID"  ,referencedColumnName="CLID")
	private Channel channel;

	//bi-directional many-to-one association to SiteMaster
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL})
	@JoinColumn(name="SMID" ,referencedColumnName="SMID")
	private SiteMaster siteMaster;

	//bi-directional many-to-one association to MembershipTypeX
	@OneToMany(mappedBy="memberMaster")
	private List<MembershipTypeX> membershipTypeXs;

	//bi-directional many-to-one association to OptIn
	@OneToMany(mappedBy="memberMaster")
	private List<OptIn> optIns;

	//bi-directional many-to-one association to Socialmedia
	@OneToMany(mappedBy="memberMaster")
	private List<Socialmedia> socialmedias;
	
	@OneToOne
	@JoinColumn(name="MMID")
	private MemberAccount memberAccount;

	public MemberMaster() {
	}

	public Long getMmid() {
		return this.mmid;
	}

	public void setMmid(Long mmid) {
		this.mmid = mmid;
	}

	public Long getCardBarCode() {
		return this.cardBarCode;
	}

	public void setCardBarCode(Long cardBarCode) {
		this.cardBarCode = cardBarCode;
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

//	public Long getMembershipTypeID() {
//		return this.membershipTypeID;
//	}
//
//	public void setMembershipTypeID(Long membershipTypeID) {
//		this.membershipTypeID = membershipTypeID;
//	}

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

	public MemberAccount getMemberAccount() {
		return memberAccount;
	}

	public void setMemberAccount(MemberAccount memberAccount) {
		this.memberAccount = memberAccount;
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

	public List<MemberMaster_AUD> getMemberMasterAuds() {
		return this.memberMasterAuds;
	}

	public void setMemberMasterAuds(List<MemberMaster_AUD> memberMasterAuds) {
		this.memberMasterAuds = memberMasterAuds;
	}

	public MemberMaster_AUD addMemberMasterAud(MemberMaster_AUD memberMasterAud) {
		getMemberMasterAuds().add(memberMasterAud);
		memberMasterAud.setMemberMaster(this);

		return memberMasterAud;
	}

	public MemberMaster_AUD removeMemberMasterAud(MemberMaster_AUD memberMasterAud) {
		getMemberMasterAuds().remove(memberMasterAud);
		memberMasterAud.setMemberMaster(null);

		return memberMasterAud;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setMemberMaster(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setMemberMaster(null);

		return address;
	}

	public List<MemberActivation> getMemberActivations() {
		return this.memberActivations;
	}

	public void setMemberActivations(List<MemberActivation> memberActivations) {
		this.memberActivations = memberActivations;
	}

	public MemberActivation addMemberActivation(MemberActivation memberActivation) {
		getMemberActivations().add(memberActivation);
		memberActivation.setMemberMaster(this);

		return memberActivation;
	}

	public MemberActivation removeMemberActivation(MemberActivation memberActivation) {
		getMemberActivations().remove(memberActivation);
		memberActivation.setMemberMaster(null);

		return memberActivation;
	}

	public Channel getChannel() {
		return this.channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public SiteMaster getSiteMaster() {
		return this.siteMaster;
	}

	public void setSiteMaster(SiteMaster siteMaster) {
		this.siteMaster = siteMaster;
	}

	public List<MembershipTypeX> getMembershipTypeXs() {
		return this.membershipTypeXs;
	}

	public void setMembershipTypeXs(List<MembershipTypeX> membershipTypeXs) {
		this.membershipTypeXs = membershipTypeXs;
	}

	public MembershipTypeX addMembershipTypeX(MembershipTypeX membershipTypeX) {
		getMembershipTypeXs().add(membershipTypeX);
		membershipTypeX.setMemberMaster(this);

		return membershipTypeX;
	}

	public MembershipTypeX removeMembershipTypeX(MembershipTypeX membershipTypeX) {
		getMembershipTypeXs().remove(membershipTypeX);
		membershipTypeX.setMemberMaster(null);

		return membershipTypeX;
	}

	public List<OptIn> getOptIns() {
		return this.optIns;
	}

	public void setOptIns(List<OptIn> optIns) {
		this.optIns = optIns;
	}

	public OptIn addOptIn(OptIn optIn) {
		getOptIns().add(optIn);
		optIn.setMemberMaster(this);

		return optIn;
	}

	public OptIn removeOptIn(OptIn optIn) {
		getOptIns().remove(optIn);
		optIn.setMemberMaster(null);

		return optIn;
	}

	public List<Socialmedia> getSocialmedias() {
		return this.socialmedias;
	}

	public void setSocialmedias(List<Socialmedia> socialmedias) {
		this.socialmedias = socialmedias;
	}

	public Socialmedia addSocialmedia(Socialmedia socialmedia) {
		getSocialmedias().add(socialmedia);
		socialmedia.setMemberMaster(this);

		return socialmedia;
	}

	public Socialmedia removeSocialmedia(Socialmedia socialmedia) {
		getSocialmedias().remove(socialmedia);
		socialmedia.setMemberMaster(null);

		return socialmedia;
	}

	@Override
	public String toString() {
		return "MemberMaster [mmid=" + mmid + ", cardBarCode=" + cardBarCode + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", dateOfBirth=" + dateOfBirth + ", emailaddress=" + emailaddress
				+ ", givenName=" + givenName + ", memberID=" + memberID  
				+ ", memberStatus=" + memberStatus + ", memberTypeID=" + memberTypeID + ", middleName=" + middleName
				+ ", mobileBarCodeURI=" + mobileBarCodeURI + ", nameTitle=" + nameTitle + ", parentMemberID="
				+ parentMemberID + ", profilePictureURI=" + profilePictureURI + ", socialmediaID=" + socialmediaID
				+ ", surname=" + surname + ", TCTemplateID=" + TCTemplateID + ", telephoneCountryCode="
				+ telephoneCountryCode + ", telephoneNumber=" + telephoneNumber + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", memberMasterAuds=" + memberMasterAuds + ", addresses=" + addresses
				+ ", memberActivations=" + memberActivations + ", channel=" + channel + ", siteMaster=" + siteMaster
				+ ", membershipTypeXs=" + membershipTypeXs + ", optIns=" + optIns + ", socialmedias=" + socialmedias
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TCTemplateID == null) ? 0 : TCTemplateID.hashCode());
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((cardBarCode == null) ? 0 : cardBarCode.hashCode());
		result = prime * result + ((channel == null) ? 0 : channel.hashCode());
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((emailaddress == null) ? 0 : emailaddress.hashCode());
		result = prime * result + ((givenName == null) ? 0 : givenName.hashCode());
		result = prime * result + ((memberActivations == null) ? 0 : memberActivations.hashCode());
		result = prime * result + ((memberID == null) ? 0 : memberID.hashCode());
		result = prime * result + ((memberMasterAuds == null) ? 0 : memberMasterAuds.hashCode());
		result = prime * result + ((memberStatus == null) ? 0 : memberStatus.hashCode());
		result = prime * result + ((memberTypeID == null) ? 0 : memberTypeID.hashCode());
		result = prime * result + ((membershipTypeXs == null) ? 0 : membershipTypeXs.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((mmid == null) ? 0 : mmid.hashCode());
		result = prime * result + ((mobileBarCodeURI == null) ? 0 : mobileBarCodeURI.hashCode());
		result = prime * result + ((nameTitle == null) ? 0 : nameTitle.hashCode());
		result = prime * result + ((optIns == null) ? 0 : optIns.hashCode());
		result = prime * result + ((parentMemberID == null) ? 0 : parentMemberID.hashCode());
		result = prime * result + ((profilePictureURI == null) ? 0 : profilePictureURI.hashCode());
		result = prime * result + ((siteMaster == null) ? 0 : siteMaster.hashCode());
		result = prime * result + ((socialmediaID == null) ? 0 : socialmediaID.hashCode());
		result = prime * result + ((socialmedias == null) ? 0 : socialmedias.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((telephoneCountryCode == null) ? 0 : telephoneCountryCode.hashCode());
		result = prime * result + ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		result = prime * result + ((updateBy == null) ? 0 : updateBy.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberMaster other = (MemberMaster) obj;
		if (TCTemplateID == null) {
			if (other.TCTemplateID != null)
				return false;
		} else if (!TCTemplateID.equals(other.TCTemplateID))
			return false;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (cardBarCode == null) {
			if (other.cardBarCode != null)
				return false;
		} else if (!cardBarCode.equals(other.cardBarCode))
			return false;
		if (channel == null) {
			if (other.channel != null)
				return false;
		} else if (!channel.equals(other.channel))
			return false;
		if (createBy == null) {
			if (other.createBy != null)
				return false;
		} else if (!createBy.equals(other.createBy))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (emailaddress == null) {
			if (other.emailaddress != null)
				return false;
		} else if (!emailaddress.equals(other.emailaddress))
			return false;
		if (givenName == null) {
			if (other.givenName != null)
				return false;
		} else if (!givenName.equals(other.givenName))
			return false;
		if (memberActivations == null) {
			if (other.memberActivations != null)
				return false;
		} else if (!memberActivations.equals(other.memberActivations))
			return false;
		if (memberID == null) {
			if (other.memberID != null)
				return false;
		} else if (!memberID.equals(other.memberID))
			return false;
		if (memberMasterAuds == null) {
			if (other.memberMasterAuds != null)
				return false;
		} else if (!memberMasterAuds.equals(other.memberMasterAuds))
			return false;
		if (memberStatus == null) {
			if (other.memberStatus != null)
				return false;
		} else if (!memberStatus.equals(other.memberStatus))
			return false;
		if (memberTypeID == null) {
			if (other.memberTypeID != null)
				return false;
		} else if (!memberTypeID.equals(other.memberTypeID))
			return false;
		if (membershipTypeXs == null) {
			if (other.membershipTypeXs != null)
				return false;
		} else if (!membershipTypeXs.equals(other.membershipTypeXs))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (mmid == null) {
			if (other.mmid != null)
				return false;
		} else if (!mmid.equals(other.mmid))
			return false;
		if (mobileBarCodeURI == null) {
			if (other.mobileBarCodeURI != null)
				return false;
		} else if (!mobileBarCodeURI.equals(other.mobileBarCodeURI))
			return false;
		if (nameTitle == null) {
			if (other.nameTitle != null)
				return false;
		} else if (!nameTitle.equals(other.nameTitle))
			return false;
		if (optIns == null) {
			if (other.optIns != null)
				return false;
		} else if (!optIns.equals(other.optIns))
			return false;
		if (parentMemberID == null) {
			if (other.parentMemberID != null)
				return false;
		} else if (!parentMemberID.equals(other.parentMemberID))
			return false;
		if (profilePictureURI == null) {
			if (other.profilePictureURI != null)
				return false;
		} else if (!profilePictureURI.equals(other.profilePictureURI))
			return false;
		if (siteMaster == null) {
			if (other.siteMaster != null)
				return false;
		} else if (!siteMaster.equals(other.siteMaster))
			return false;
		if (socialmediaID == null) {
			if (other.socialmediaID != null)
				return false;
		} else if (!socialmediaID.equals(other.socialmediaID))
			return false;
		if (socialmedias == null) {
			if (other.socialmedias != null)
				return false;
		} else if (!socialmedias.equals(other.socialmedias))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (telephoneCountryCode == null) {
			if (other.telephoneCountryCode != null)
				return false;
		} else if (!telephoneCountryCode.equals(other.telephoneCountryCode))
			return false;
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null)
				return false;
		} else if (!telephoneNumber.equals(other.telephoneNumber))
			return false;
		if (updateBy == null) {
			if (other.updateBy != null)
				return false;
		} else if (!updateBy.equals(other.updateBy))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}
	
}