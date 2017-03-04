package com.gaming.shack.data.enums;

/**
 * 
 * @author shahnawf
 *
 */
public enum AddressType {
	MAIlING_ADDRESS("Mail") ,
	BILLING_ADDRESS("Bill") ;
	
	private String typeValue ;
	
	AddressType(String typeValue) {
		this.typeValue = typeValue ;
	}
	
	public String getTypeValue() {
		return typeValue ;
	}
}
