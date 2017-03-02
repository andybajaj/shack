package com.gaming.shack.data.entity.registration;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the CodeMaster database table.
 * 
 */
@Entity
@Table(name="CodeMaster")
@NamedQuery(name="CodeMaster.findAll", query="SELECT c FROM CodeMaster c")
public class CodeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CDID")
	private Long cdid;

	@Column(name="CodeDescription")
	private String codeDescription;

	@Column(name="CodeType")
	private String codeType;

	@Column(name="CodeValue")
	private String codeValue;

	@Column(name="CreateBy")
	private String createBy;

	@Column(name="CreateDate")
	private Timestamp createDate;

	@Column(name="UpdateBy")
	private String updateBy;

	@Column(name="UpdateDate")
	private Timestamp updateDate;

	public CodeMaster() {
	}

	public Long getCdid() {
		return this.cdid;
	}

	public void setCdid(Long cdid) {
		this.cdid = cdid;
	}

	public String getCodeDescription() {
		return this.codeDescription;
	}

	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}

	public String getCodeType() {
		return this.codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeValue() {
		return this.codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
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

}