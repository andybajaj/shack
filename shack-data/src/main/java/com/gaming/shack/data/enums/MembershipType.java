package com.gaming.shack.data.enums;

/**
 * 
 * @author shahnawf
 *
 */
public enum MembershipType {
	LIFETIME(1) ,
	VIP3(2) , 
	VIP6(3) ;
	
	private int typeValue ;
	
	MembershipType(int typeValue) {
		this.typeValue = typeValue ;
	}
	
	public int getValue() {
		return this.typeValue ;
	}
}
