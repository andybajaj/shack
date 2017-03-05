package com.gaming.shack.data.enums;

/**
 * 
 * @author shahnawf
 *
 */
public enum ProfileType {
	BASIC("basic") ,
	FULL("full") ;
	
	private String typeValue ;
	
	ProfileType(String typeValue) {
		this.typeValue = typeValue ;
	}
	
	public String getTypeValue() {
		return typeValue ;
	}
	
	public String valueOf(){
		return this.typeValue;
	}
	
	public static ProfileType toEnum(String s) {

		for (ProfileType profileType : ProfileType.values()) {
			if (profileType.valueOf().equalsIgnoreCase(s)) {
				return profileType;
			}
		}
		return null;
	}
}
