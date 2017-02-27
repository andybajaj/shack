/*
 * 
 */
package com.gaming.shack.core.enums;

// TODO: Auto-generated Javadoc
/**
 * The Enum ExitStatusType.
 *
 * @author sharies
 */
public enum ExitStatusType {

	/** The success. */
	SUCCESS("Success"), /** The bad request. */
 BAD_REQUEST("Validation Fail"), /** The failed. */
 FAILED("Fail");

	/** The name. */
	private final String name;

	/**
	 * Instantiates a new exit status type.
	 *
	 * @param s the s
	 */
	private ExitStatusType(String s) {
		name = s;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return name;
	}

}
