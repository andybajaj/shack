package com.gaming.shack.data.model;

/**
 * A class to represent when 
 * memer adds successfully
 * @author shahnawf
 *
 */
public class MemberSuccess {
	private Long memberId ;
	
	/**
	 * 
	 * @param memberId
	 */
	public MemberSuccess(Long memberId) {
		this.memberId = memberId ;
	}
	
	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	
	
	@Override
	public String toString() {
		return "MemberSuccess [memberId=" + memberId + "]";
	}
	
	
}
