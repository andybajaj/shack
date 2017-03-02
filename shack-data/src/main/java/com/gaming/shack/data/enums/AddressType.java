package com.gaming.shack.data.enums;

/**
 * 
 * @author shahnawf
 *
 */
public enum AddressType {
	MAIlING_ADDRESS("mailaddress") ,
	BILLING_ADDRESS("billingaddress") ;
	
	private String typeValue ;
	
	AddressType(String typeValue) {
		this.typeValue = typeValue ;
	}
}
