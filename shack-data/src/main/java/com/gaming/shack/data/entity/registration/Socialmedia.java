package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Socialmedia database table.
 * 
 */
@Entity
@Table(name="Socialmedia")
@NamedQuery(name="Socialmedia.findAll", query="SELECT s FROM Socialmedia s")
public class Socialmedia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SMID")
	private Long smid;

	@Column(name="CreateBy")
	private String createBy;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Column(name="PreferredContactInd")
	private String preferredContactInd;

	@Column(name="SocialmediaID")
	private Long socialmediaID;

	@Column(name="SocialmediaType")
	private String socialmediaType;

	@Column(name="UpdateBy")
	private String updateBy;

	@Column(name="UpdateDate")
	private Timestamp updateDate;

	@Column(name="UserName")
	private String userName;

	//bi-directional many-to-one association to MemberMaster
	@ManyToOne
	@JoinColumn(name="MMID")
	private MemberMaster memberMaster;

	public Socialmedia() {
	}

	public Long getSmid() {
		return this.smid;
	}

	public void setSmid(Long smid) {
		this.smid = smid;
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

	public String getPreferredContactInd() {
		return this.preferredContactInd;
	}

	public void setPreferredContactInd(String preferredContactInd) {
		this.preferredContactInd = preferredContactInd;
	}

	public Long getSocialmediaID() {
		return this.socialmediaID;
	}

	public void setSocialmediaID(Long socialmediaID) {
		this.socialmediaID = socialmediaID;
	}

	public String getSocialmediaType() {
		return this.socialmediaType;
	}

	public void setSocialmediaType(String socialmediaType) {
		this.socialmediaType = socialmediaType;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public MemberMaster getMemberMaster() {
		return this.memberMaster;
	}

	public void setMemberMaster(MemberMaster memberMaster) {
		this.memberMaster = memberMaster;
	}

	@Override
	public String toString() {
		return "Socialmedia [smid=" + smid + ", createBy=" + createBy + ", createDate=" + createDate
				+ ", preferredContactInd=" + preferredContactInd + ", socialmediaID=" + socialmediaID
				+ ", socialmediaType=" + socialmediaType + ", updateBy=" + updateBy + ", updateDate=" + updateDate
				+ ", userName=" + userName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((memberMaster == null) ? 0 : memberMaster.hashCode());
		result = prime * result + ((preferredContactInd == null) ? 0 : preferredContactInd.hashCode());
		result = prime * result + ((smid == null) ? 0 : smid.hashCode());
		result = prime * result + ((socialmediaID == null) ? 0 : socialmediaID.hashCode());
		result = prime * result + ((socialmediaType == null) ? 0 : socialmediaType.hashCode());
		result = prime * result + ((updateBy == null) ? 0 : updateBy.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		Socialmedia other = (Socialmedia) obj;
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
		if (memberMaster == null) {
			if (other.memberMaster != null)
				return false;
		} else if (!memberMaster.equals(other.memberMaster))
			return false;
		if (preferredContactInd == null) {
			if (other.preferredContactInd != null)
				return false;
		} else if (!preferredContactInd.equals(other.preferredContactInd))
			return false;
		if (smid == null) {
			if (other.smid != null)
				return false;
		} else if (!smid.equals(other.smid))
			return false;
		if (socialmediaID == null) {
			if (other.socialmediaID != null)
				return false;
		} else if (!socialmediaID.equals(other.socialmediaID))
			return false;
		if (socialmediaType == null) {
			if (other.socialmediaType != null)
				return false;
		} else if (!socialmediaType.equals(other.socialmediaType))
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
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
}