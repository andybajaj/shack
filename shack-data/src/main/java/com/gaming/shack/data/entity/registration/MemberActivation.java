package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the MemberActivation database table.
 * 
 */
@Entity
@Table(name="MemberActivation")
@NamedQuery(name="MemberActivation.findAll", query="SELECT m FROM MemberActivation m")
public class MemberActivation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long maid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ActivationTime")
	private Date activationTime;

	@Column(name="ActivationType")
	private String activationType;

	@Column(name="CreateBy")
	private String createBy;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CreationTime")
	private Date creationTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ExpiryTime")
	private Date expiryTime;

	@Column(name="UniqueID")
	private String uniqueID;

	@Column(name="UpdateBy")
	private String updateBy;

	@Column(name="UpdateDate")
	private Timestamp updateDate;

	@Column(name="ValidityMinute")
	private Long validityMinute;

	//bi-directional many-to-one association to MemberMaster
	@ManyToOne
	@JoinColumn(name="MMID")
	private MemberMaster memberMaster;

	public MemberActivation() {
	}

	public Long getMaid() {
		return this.maid;
	}

	public void setMaid(Long maid) {
		this.maid = maid;
	}

	public Date getActivationTime() {
		return this.activationTime;
	}

	public void setActivationTime(Date activationTime) {
		this.activationTime = activationTime;
	}

	public String getActivationType() {
		return this.activationType;
	}

	public void setActivationType(String activationType) {
		this.activationType = activationType;
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

	public Date getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getExpiryTime() {
		return this.expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getUniqueID() {
		return this.uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
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

	public Long getValidityMinute() {
		return this.validityMinute;
	}

	public void setValidityMinute(Long validityMinute) {
		this.validityMinute = validityMinute;
	}

	public MemberMaster getMemberMaster() {
		return this.memberMaster;
	}

	public void setMemberMaster(MemberMaster memberMaster) {
		this.memberMaster = memberMaster;
	}

	@Override
	public String toString() {
		return "MemberActivation [maid=" + maid + ", activationTime=" + activationTime + ", activationType="
				+ activationType + ", createBy=" + createBy + ", createDate=" + createDate + ", creationTime="
				+ creationTime + ", expiryTime=" + expiryTime + ", uniqueID=" + uniqueID + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + ", validityMinute=" + validityMinute + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activationTime == null) ? 0 : activationTime.hashCode());
		result = prime * result + ((activationType == null) ? 0 : activationType.hashCode());
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((expiryTime == null) ? 0 : expiryTime.hashCode());
		result = prime * result + ((maid == null) ? 0 : maid.hashCode());
		result = prime * result + ((memberMaster == null) ? 0 : memberMaster.hashCode());
		result = prime * result + ((uniqueID == null) ? 0 : uniqueID.hashCode());
		result = prime * result + ((updateBy == null) ? 0 : updateBy.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((validityMinute == null) ? 0 : validityMinute.hashCode());
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
		MemberActivation other = (MemberActivation) obj;
		if (activationTime == null) {
			if (other.activationTime != null)
				return false;
		} else if (!activationTime.equals(other.activationTime))
			return false;
		if (activationType == null) {
			if (other.activationType != null)
				return false;
		} else if (!activationType.equals(other.activationType))
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
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (expiryTime == null) {
			if (other.expiryTime != null)
				return false;
		} else if (!expiryTime.equals(other.expiryTime))
			return false;
		if (maid == null) {
			if (other.maid != null)
				return false;
		} else if (!maid.equals(other.maid))
			return false;
		if (memberMaster == null) {
			if (other.memberMaster != null)
				return false;
		} else if (!memberMaster.equals(other.memberMaster))
			return false;
		if (uniqueID == null) {
			if (other.uniqueID != null)
				return false;
		} else if (!uniqueID.equals(other.uniqueID))
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
		if (validityMinute == null) {
			if (other.validityMinute != null)
				return false;
		} else if (!validityMinute.equals(other.validityMinute))
			return false;
		return true;
	}
	
	
}