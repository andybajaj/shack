package com.gaming.shack.data.enums;

/**
 * 
 * @author shahnawf
 *
 */
public enum AddressType {
	MAIL("Mail") ,
	BILL("Bill") ;
	
	private String typeValue ;
	
	AddressType(String typeValue) {
		this.typeValue = typeValue ;
	}
	
	public String getTypeValue() {
		return typeValue ;
	}
	
	public String valueOf(){
		return this.typeValue;
	}
}
