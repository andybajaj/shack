package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the MembershipTypeX database table.
 * 
 */
@Entity
@Table(name="MembershipTypeX")
@NamedQuery(name="MembershipTypeX.findAll", query="SELECT m FROM MembershipTypeX m")
public class MembershipTypeX implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MXID")
	private Long mxid;

	@Column(name="CreateBy")
	private String createBy;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ExpiryDate")
	private Date expiryDate;

	@Temporal(TemporalType.DATE)
	@Column(name="StartDate")
	private Date startDate;

	@Column(name="UpdateBy")
	private String updateBy;

	@Column(name="UpdateDate")
	private Timestamp updateDate;

	//bi-directional many-to-one association to MemberMaster
	@ManyToOne
	@JoinColumn(name="MMID")
	private MemberMaster memberMaster;

	//bi-directional many-to-one association to MembershipTypeDetail
	@ManyToOne
	@JoinColumn(name="MTID")
	private MembershipTypeDetail membershipTypeDetail;

	public MembershipTypeX() {
	}

	public Long getMxid() {
		return this.mxid;
	}

	public void setMxid(Long mxid) {
		this.mxid = mxid;
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

	public Date getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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

	public MembershipTypeDetail getMembershipTypeDetail() {
		return this.membershipTypeDetail;
	}

	public void setMembershipTypeDetail(MembershipTypeDetail membershipTypeDetail) {
		this.membershipTypeDetail = membershipTypeDetail;
	}

	@Override
	public String toString() {
		return "MembershipTypeX [mxid=" + mxid + ", createBy=" + createBy + ", createDate=" + createDate
				+ ", expiryDate=" + expiryDate + ", startDate=" + startDate + ", updateBy=" + updateBy + ", updateDate="
				+ updateDate + ", membershipTypeDetail=" + membershipTypeDetail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((memberMaster == null) ? 0 : memberMaster.hashCode());
		result = prime * result + ((membershipTypeDetail == null) ? 0 : membershipTypeDetail.hashCode());
		result = prime * result + ((mxid == null) ? 0 : mxid.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		MembershipTypeX other = (MembershipTypeX) obj;
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
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (memberMaster == null) {
			if (other.memberMaster != null)
				return false;
		} else if (!memberMaster.equals(other.memberMaster))
			return false;
		if (membershipTypeDetail == null) {
			if (other.membershipTypeDetail != null)
				return false;
		} else if (!membershipTypeDetail.equals(other.membershipTypeDetail))
			return false;
		if (mxid == null) {
			if (other.mxid != null)
				return false;
		} else if (!mxid.equals(other.mxid))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
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