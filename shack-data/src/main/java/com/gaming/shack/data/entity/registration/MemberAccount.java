package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the MemberActivation database table.
 * 
 */
@Entity
@Table(name="MemberAccount")
@NamedQuery(name="MemberAccount.findAll", query="SELECT m FROM MemberAccount m")
public class MemberAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAID")
	private Long memHisId;

	@Column(name="Password")
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LastLogin")
	private Date lastLogin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CreatedOn")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LastUpdateDate")
	private Date lastUpdateDate;

	@Column(name="LastPasswordReset")
	private String lastPasswordReset;

	@Column(name="NoOfFailAttem")
	private Long noOfFailAttem;

	@Column(name="ResetPwdFailAttem")
	private Long resetPwdFailAttem;

	@Column(name="Status")
	private String status;

	@Column(name="MMID")
	private Long memberID;

	public Long getMemHisId() {
		return memHisId;
	}

	public void setMemHisId(Long memHisId) {
		this.memHisId = memHisId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastPasswordReset() {
		return lastPasswordReset;
	}

	public void setLastPasswordReset(String lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}

	public Long getNoOfFailAttem() {
		return noOfFailAttem;
	}

	public void setNoOfFailAttem(Long noOfFailAttem) {
		this.noOfFailAttem = noOfFailAttem;
	}

	public Long getResetPwdFailAttem() {
		return resetPwdFailAttem;
	}

	public void setResetPwdFailAttem(Long resetPwdFailAttem) {
		this.resetPwdFailAttem = resetPwdFailAttem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getMemberID() {
		return memberID;
	}

	public void setMemberID(Long memberID) {
		this.memberID = memberID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdOn == null) ? 0 : createdOn.hashCode());
		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((lastPasswordReset == null) ? 0 : lastPasswordReset.hashCode());
		result = prime * result + ((lastUpdateDate == null) ? 0 : lastUpdateDate.hashCode());
		result = prime * result + ((memHisId == null) ? 0 : memHisId.hashCode());
		result = prime * result + ((memberID == null) ? 0 : memberID.hashCode());
		result = prime * result + ((noOfFailAttem == null) ? 0 : noOfFailAttem.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((resetPwdFailAttem == null) ? 0 : resetPwdFailAttem.hashCode());
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
		MemberAccount other = (MemberAccount) obj;
		if (createdOn == null) {
			if (other.createdOn != null)
				return false;
		} else if (!createdOn.equals(other.createdOn))
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (lastPasswordReset == null) {
			if (other.lastPasswordReset != null)
				return false;
		} else if (!lastPasswordReset.equals(other.lastPasswordReset))
			return false;
		if (lastUpdateDate == null) {
			if (other.lastUpdateDate != null)
				return false;
		} else if (!lastUpdateDate.equals(other.lastUpdateDate))
			return false;
		if (memHisId == null) {
			if (other.memHisId != null)
				return false;
		} else if (!memHisId.equals(other.memHisId))
			return false;
		if (memberID == null) {
			if (other.memberID != null)
				return false;
		} else if (!memberID.equals(other.memberID))
			return false;
		if (noOfFailAttem == null) {
			if (other.noOfFailAttem != null)
				return false;
		} else if (!noOfFailAttem.equals(other.noOfFailAttem))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (resetPwdFailAttem == null) {
			if (other.resetPwdFailAttem != null)
				return false;
		} else if (!resetPwdFailAttem.equals(other.resetPwdFailAttem))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberAccount [memHisId=" + memHisId + ", password=" + password + ", lastLogin=" + lastLogin
				+ ", createdOn=" + createdOn + ", lastUpdateDate=" + lastUpdateDate + ", lastPasswordReset="
				+ lastPasswordReset + ", noOfFailAttem=" + noOfFailAttem + ", resetPwdFailAttem=" + resetPwdFailAttem
				+ ", status=" + status + ", memberID=" + memberID + "]";
	}

	
	
	
}