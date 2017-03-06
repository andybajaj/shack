package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the OptIns database table.
 * 
 */
@Entity
@Table(name="OptIns")
@NamedQuery(name="OptIn.findAll", query="SELECT o FROM OptIn o")
public class OptIn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="OPID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long opid;

	@Temporal(TemporalType.DATE)
	@Column(name="AcceptedDate")
	private Date acceptedDate;

	@Column(name="CreateBy")
	private String createBy;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Column(name="OptTypeID")
	private Long optTypeID;

	@Column(name="Status")
	private String status;

	@Column(name="UpdateBy")
	private String updateBy;

	@Column(name="UpdateDate")
	private Timestamp updateDate;

	//bi-directional many-to-one association to MemberMaster
	@ManyToOne
	@JoinColumn(name="MMID" , referencedColumnName="MMID")
	private MemberMaster memberMaster;

	public OptIn() {
	}

	public Long getOpid() {
		return this.opid;
	}

	public void setOpid(Long opid) {
		this.opid = opid;
	}

	public Date getAcceptedDate() {
		return this.acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
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

	public Long getOptTypeID() {
		return this.optTypeID;
	}

	public void setOptTypeID(Long optTypeID) {
		this.optTypeID = optTypeID;
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

	public MemberMaster getMemberMaster() {
		return this.memberMaster;
	}

	public void setMemberMaster(MemberMaster memberMaster) {
		this.memberMaster = memberMaster;
	}

	@Override
	public String toString() {
		return "OptIn [opid=" + opid + ", acceptedDate=" + acceptedDate + ", createBy=" + createBy + ", createDate="
				+ createDate + ", optTypeID=" + optTypeID + ", status=" + status + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberMaster.getMmid() == null) ? 0 : memberMaster.getMmid().hashCode());
		result = prime * result + ((optTypeID == null) ? 0 : optTypeID.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		OptIn other = (OptIn) obj;
		if (memberMaster == null) {
			if (other.memberMaster != null)
				return false;
		} else if (!memberMaster.getMmid().equals(other.memberMaster.getMmid()))
			return false;
		if (optTypeID == null) {
			if (other.optTypeID != null)
				return false;
		} else if (!optTypeID.equals(other.optTypeID))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	
	
	
}