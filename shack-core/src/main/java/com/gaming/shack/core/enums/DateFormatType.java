/*
 * 
 */
package com.gaming.shack.core.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum DateFormatType.
 */
public enum DateFormatType {

    /** The date format. */
    DATE_FORMAT("MM/dd/yyyy"),
    
    /** The date format1. */
    DATE_FORMAT1("yyyy-MM-dd"),
    
    /** The date format2. */
    DATE_FORMAT2("MMM dd,yyyy"),
    
    /** The date format4. */
    DATE_FORMAT4("MM_dd_yyyy"),

    /** The timestamp format. */
    TIMESTAMP_FORMAT("dd-MMM-yyyy HH:mm:ss"),
    
    /** The timestamp format1. */
    TIMESTAMP_FORMAT1("dd-MMM-yyyy_HH-mm-ss"),
	
	/** The ampm format. */
	AMPM_FORMAT("MM/dd/yyyy hh:mm a");

    /** The value. */
    private String value;

    /**
     * Instantiates a new date format type.
     *
     * @param value the value
     */
    private DateFormatType(String value) {
        this.value = value;
    }
    
    /**
     * Value of.
     *
     * @return the string
     */
    public String valueOf() {
        return this.value;
    }

}
