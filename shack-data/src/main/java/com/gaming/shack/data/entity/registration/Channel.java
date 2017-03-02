package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Channel database table.
 * 
 */
@Entity
@NamedQuery(name="Channel.findAll", query="SELECT c FROM Channel c")
@Table(name="Channel")
public class Channel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CLID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long clid;

	@Column(name="ChannelDescription")
	private String channelDescription;

	@Column(name="ChannelID")
	private Long channelID;

	@Column(name="ChannelType")
	private String channelType;

	@Column(name="CreateBy")
	private String createBy;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Column(name="UpdateBy")
	private String updateBy;

	@Column(name="UpdateDate")
	private Timestamp updateDate;

	//bi-directional many-to-one association to MemberMaster
	@OneToMany(mappedBy="channel")
	private List<MemberMaster> memberMasters;

	public Channel() {
	}

	public Long getClid() {
		return this.clid;
	}

	public void setClid(Long clid) {
		this.clid = clid;
	}

	public String getChannelDescription() {
		return this.channelDescription;
	}

	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}

	public Long getChannelID() {
		return this.channelID;
	}

	public void setChannelID(Long channelID) {
		this.channelID = channelID;
	}

	public String getChannelType() {
		return this.channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
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

	public List<MemberMaster> getMemberMasters() {
		return this.memberMasters;
	}

	public void setMemberMasters(List<MemberMaster> memberMasters) {
		this.memberMasters = memberMasters;
	}

	public MemberMaster addMemberMaster(MemberMaster memberMaster) {
		getMemberMasters().add(memberMaster);
		memberMaster.setChannel(this);

		return memberMaster;
	}

	public MemberMaster removeMemberMaster(MemberMaster memberMaster) {
		getMemberMasters().remove(memberMaster);
		memberMaster.setChannel(null);

		return memberMaster;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((channelDescription == null) ? 0 : channelDescription.hashCode());
		result = prime * result + ((channelID == null) ? 0 : channelID.hashCode());
		result = prime * result + ((channelType == null) ? 0 : channelType.hashCode());
		result = prime * result + ((clid == null) ? 0 : clid.hashCode());
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((memberMasters == null) ? 0 : memberMasters.hashCode());
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
		Channel other = (Channel) obj;
		if (channelDescription == null) {
			if (other.channelDescription != null)
				return false;
		} else if (!channelDescription.equals(other.channelDescription))
			return false;
		if (channelID == null) {
			if (other.channelID != null)
				return false;
		} else if (!channelID.equals(other.channelID))
			return false;
		if (channelType == null) {
			if (other.channelType != null)
				return false;
		} else if (!channelType.equals(other.channelType))
			return false;
		if (clid == null) {
			if (other.clid != null)
				return false;
		} else if (!clid.equals(other.clid))
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
		if (memberMasters == null) {
			if (other.memberMasters != null)
				return false;
		} else if (!memberMasters.equals(other.memberMasters))
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

	@Override
	public String toString() {
		return "Channel [clid=" + clid + ", channelDescription=" + channelDescription + ", channelID=" + channelID
				+ ", channelType=" + channelType + ", createBy=" + createBy + ", createDate=" + createDate
				+ ", updateBy=" + updateBy + ", updateDate=" + updateDate + "]";
	}
	
	
}