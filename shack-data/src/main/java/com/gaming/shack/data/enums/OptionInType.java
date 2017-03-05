package com.gaming.shack.data.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author shahnawf
 *
 */
public enum OptionInType {
	OPTION1(1 , "id123") ,
	OPTION2(2 , "id234") , 
	OPTION3(3 , "id456") ;
	
	private int optionValue ;
	private String optionLabel ;	
	
	/**
	 * 
	 * @param optionValue
	 * @param optionLabel
	 */
	OptionInType(int optionValue , String optionLabel) {
		this.optionValue = optionValue ;
		this.optionLabel = optionLabel ;		
	}

	public int getOptionValue() {
		return optionValue;
	}
	
	public String getOptionLabel() {		
		return optionLabel;
	}
		
			
}
