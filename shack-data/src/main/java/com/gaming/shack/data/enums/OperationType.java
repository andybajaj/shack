package com.gaming.shack.data.enums;

/**
 * 
 * @author shahnawf
 *
 */
public enum OperationType {
	ADD("add") ,
	UPDATE("update") ;
	
	private String typeValue ;
	
	/**
	 * 
	 * @param typeValue
	 */
	OperationType(String typeValue) {
		this.typeValue = typeValue ;
	}
		
	/**
	 * 
	 * @return
	 */
	public String getTypeValue() {
		return typeValue ;
	}
	
	/**
	 * 
	 * @return
	 */
	public String valueOf(){
		return this.typeValue;
	}
}
