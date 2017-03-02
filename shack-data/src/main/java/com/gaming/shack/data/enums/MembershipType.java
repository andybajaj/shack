package com.gaming.shack.data.enums;

/**
 * 
 * @author shahnawf
 *
 */
public enum MembershipType {
	MINOR(1) ,
	ADULT(2) , 
	SR_CITIZE(3) ;
	
	private int typeValue ;
	
	MembershipType(int typeValue) {
		this.typeValue = typeValue ;
	}
}
