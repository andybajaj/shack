package com.gaming.shack.data.enums;

/**
 * 
 * @author shahnawf
 *
 */
public enum MemberType {
	MINOR(1) ,
	ADULT(2) , 
	SR_CITIZE(3) ;
	
	private int typeValue ;
	
	MemberType(int typeValue) {
		this.typeValue = typeValue ;
	}
	
	public int getValue() {
		return this.typeValue ;
	}
	
	public static MemberType toEnum(int s) {

		for (MemberType memberType : MemberType.values()) {
			if (memberType.getValue()==s) {
				return memberType;
			}
		}
		return null;
	}
	
}
