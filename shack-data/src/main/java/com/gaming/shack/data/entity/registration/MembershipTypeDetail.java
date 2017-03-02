package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the MembershipTypeDetail database table.
 * 
 */
@Entity
@Table(name="MembershipTypeDetail")
@NamedQuery(name="MembershipTypeDetail.findAll", query="SELECT m FROM MembershipTypeDetail m")
public class MembershipTypeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MTID")
	private Long mtid;

	@Column(name="ClubRentalFlag")
	private String clubRentalFlag;

	@Column(name="CreateBy")
	private String createBy;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Column(name="Details")
	private String details;

	@Temporal(TemporalType.DATE)
	@Column(name="EffectiveEndDate")
	private Date effectiveEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="EffectiveStartDate")
	private Date effectiveStartDate;

	@Column(name="MembershipDescription")
	private String membershipDescription;

	@Column(name="NonAlcholicDiscount")
	private Long nonAlcholicDiscount;

	@Column(name="OffpeakGames")
	private Long offpeakGames;

	@Column(name="OnlineAccountFlag")
	private String onlineAccountFlag;

	@Column(name="Status")
	private String status;

	@Column(name="UpdateBy")
	private String updateBy;

	@Column(name="UpdateDate")
	private Timestamp updateDate;

	@Column(name="ValidityDuration")
	private Long validityDuration;

	//bi-directional many-to-one association to MembershipTypeX
	@OneToMany(mappedBy="membershipTypeDetail")
	private List<MembershipTypeX> membershipTypeXs;

	public MembershipTypeDetail() {
	}

	public Long getMtid() {
		return this.mtid;
	}

	public void setMtid(Long mtid) {
		this.mtid = mtid;
	}

	public String getClubRentalFlag() {
		return this.clubRentalFlag;
	}

	public void setClubRentalFlag(String clubRentalFlag) {
		this.clubRentalFlag = clubRentalFlag;
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

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getEffectiveEndDate() {
		return this.effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public Date getEffectiveStartDate() {
		return this.effectiveStartDate;
	}

	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getMembershipDescription() {
		return this.membershipDescription;
	}

	public void setMembershipDescription(String membershipDescription) {
		this.membershipDescription = membershipDescription;
	}

	public Long getNonAlcholicDiscount() {
		return this.nonAlcholicDiscount;
	}

	public void setNonAlcholicDiscount(Long nonAlcholicDiscount) {
		this.nonAlcholicDiscount = nonAlcholicDiscount;
	}

	public Long getOffpeakGames() {
		return this.offpeakGames;
	}

	public void setOffpeakGames(Long offpeakGames) {
		this.offpeakGames = offpeakGames;
	}

	public String getOnlineAccountFlag() {
		return this.onlineAccountFlag;
	}

	public void setOnlineAccountFlag(String onlineAccountFlag) {
		this.onlineAccountFlag = onlineAccountFlag;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Long getValidityDuration() {
		return this.validityDuration;
	}

	public void setValidityDuration(Long validityDuration) {
		this.validityDuration = validityDuration;
	}

	public List<MembershipTypeX> getMembershipTypeXs() {
		return this.membershipTypeXs;
	}

	public void setMembershipTypeXs(List<MembershipTypeX> membershipTypeXs) {
		this.membershipTypeXs = membershipTypeXs;
	}

	public MembershipTypeX addMembershipTypeX(MembershipTypeX membershipTypeX) {
		getMembershipTypeXs().add(membershipTypeX);
		membershipTypeX.setMembershipTypeDetail(this);

		return membershipTypeX;
	}

	public MembershipTypeX removeMembershipTypeX(MembershipTypeX membershipTypeX) {
		getMembershipTypeXs().remove(membershipTypeX);
		membershipTypeX.setMembershipTypeDetail(null);

		return membershipTypeX;
	}

	@Override
	public String toString() {
		return "MembershipTypeDetail [mtid=" + mtid + ", clubRentalFlag=" + clubRentalFlag + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", details=" + details + ", effectiveEndDate=" + effectiveEndDate
				+ ", effectiveStartDate=" + effectiveStartDate + ", membershipDescription=" + membershipDescription
				+ ", nonAlcholicDiscount=" + nonAlcholicDiscount + ", offpeakGames=" + offpeakGames
				+ ", onlineAccountFlag=" + onlineAccountFlag + ", status=" + status + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", validityDuration=" + validityDuration + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clubRentalFlag == null) ? 0 : clubRentalFlag.hashCode());
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((effectiveEndDate == null) ? 0 : effectiveEndDate.hashCode());
		result = prime * result + ((effectiveStartDate == null) ? 0 : effectiveStartDate.hashCode());
		result = prime * result + ((membershipDescription == null) ? 0 : membershipDescription.hashCode());
		result = prime * result + ((membershipTypeXs == null) ? 0 : membershipTypeXs.hashCode());
		result = prime * result + ((mtid == null) ? 0 : mtid.hashCode());
		result = prime * result + ((nonAlcholicDiscount == null) ? 0 : nonAlcholicDiscount.hashCode());
		result = prime * result + ((offpeakGames == null) ? 0 : offpeakGames.hashCode());
		result = prime * result + ((onlineAccountFlag == null) ? 0 : onlineAccountFlag.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updateBy == null) ? 0 : updateBy.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((validityDuration == null) ? 0 : validityDuration.hashCode());
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
		MembershipTypeDetail other = (MembershipTypeDetail) obj;
		if (clubRentalFlag == null) {
			if (other.clubRentalFlag != null)
				return false;
		} else if (!clubRentalFlag.equals(other.clubRentalFlag))
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
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (effectiveEndDate == null) {
			if (other.effectiveEndDate != null)
				return false;
		} else if (!effectiveEndDate.equals(other.effectiveEndDate))
			return false;
		if (effectiveStartDate == null) {
			if (other.effectiveStartDate != null)
				return false;
		} else if (!effectiveStartDate.equals(other.effectiveStartDate))
			return false;
		if (membershipDescription == null) {
			if (other.membershipDescription != null)
				return false;
		} else if (!membershipDescription.equals(other.membershipDescription))
			return false;
		if (membershipTypeXs == null) {
			if (other.membershipTypeXs != null)
				return false;
		} else if (!membershipTypeXs.equals(other.membershipTypeXs))
			return false;
		if (mtid == null) {
			if (other.mtid != null)
				return false;
		} else if (!mtid.equals(other.mtid))
			return false;
		if (nonAlcholicDiscount == null) {
			if (other.nonAlcholicDiscount != null)
				return false;
		} else if (!nonAlcholicDiscount.equals(other.nonAlcholicDiscount))
			return false;
		if (offpeakGames == null) {
			if (other.offpeakGames != null)
				return false;
		} else if (!offpeakGames.equals(other.offpeakGames))
			return false;
		if (onlineAccountFlag == null) {
			if (other.onlineAccountFlag != null)
				return false;
		} else if (!onlineAccountFlag.equals(other.onlineAccountFlag))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		if (validityDuration == null) {
			if (other.validityDuration != null)
				return false;
		} else if (!validityDuration.equals(other.validityDuration))
			return false;
		return true;
	}
	
	
}