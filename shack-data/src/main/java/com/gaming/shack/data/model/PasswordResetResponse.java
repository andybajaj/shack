package com.gaming.shack.data.model;

import java.io.Serializable;

public class PasswordResetResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	

	private Long memberId;
	private  String emailId;
	
	public PasswordResetResponse(){
		
	}
	
	public PasswordResetResponse(Long memId,String emailId){
		
		super();
		this.memberId = memId;
		this.emailId = emailId;
		
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		return "PassordResetResponse [memberId=" + memberId + ", emailId=" + emailId + "]";
	}
	
}
