package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the SiteMaster database table.
 * 
 */
@Entity
@Table(name="SiteMaster")
@NamedQuery(name="SiteMaster.findAll", query="SELECT s FROM SiteMaster s")
public class SiteMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SMID")
	private Long smid;

	@Column(name="AddressLine1")
	private String addressLine1;

	@Column(name="AddressLine2")
	private String addressLine2;

	@Column(name="CityName")
	private String cityName;

	@Column(name="Country")
	private String country;

	@Column(name="CreateBy")
	private String createBy;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Column(name="Latitude")
	private float latitude;

	@Column(name="Longitude")
	private float longitude;

	@Column(name="PostalCode")
	private String postalCode;

	@Column(name="StateProv")
	private String stateProv;

	@Column(name="UpdateBy")
	private String updateBy;

	@Column(name="UpdateDate")
	private Timestamp updateDate;

	//bi-directional many-to-one association to MemberMaster
	@OneToMany(mappedBy="siteMaster")
	private List<MemberMaster> memberMasters;

	public SiteMaster() {
	}

	public Long getSmid() {
		return this.smid;
	}

	public void setSmid(Long smid) {
		this.smid = smid;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateProv() {
		return this.stateProv;
	}

	public void setStateProv(String stateProv) {
		this.stateProv = stateProv;
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
		memberMaster.setSiteMaster(this);

		return memberMaster;
	}

	public MemberMaster removeMemberMaster(MemberMaster memberMaster) {
		getMemberMasters().remove(memberMaster);
		memberMaster.setSiteMaster(null);

		return memberMaster;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + Float.floatToIntBits(latitude);
		result = prime * result + Float.floatToIntBits(longitude);
		result = prime * result + ((memberMasters == null) ? 0 : memberMasters.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((smid == null) ? 0 : smid.hashCode());
		result = prime * result + ((stateProv == null) ? 0 : stateProv.hashCode());
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
		SiteMaster other = (SiteMaster) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
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
		if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
			return false;
		if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
			return false;
		if (memberMasters == null) {
			if (other.memberMasters != null)
				return false;
		} else if (!memberMasters.equals(other.memberMasters))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (smid == null) {
			if (other.smid != null)
				return false;
		} else if (!smid.equals(other.smid))
			return false;
		if (stateProv == null) {
			if (other.stateProv != null)
				return false;
		} else if (!stateProv.equals(other.stateProv))
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
		return "SiteMaster [smid=" + smid + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", cityName=" + cityName + ", country=" + country + ", createBy=" + createBy + ", createDate="
				+ createDate + ", latitude=" + latitude + ", longitude=" + longitude + ", postalCode=" + postalCode
				+ ", stateProv=" + stateProv + ", updateBy=" + updateBy + ", updateDate=" + updateDate + "]";
	}
	
	
}