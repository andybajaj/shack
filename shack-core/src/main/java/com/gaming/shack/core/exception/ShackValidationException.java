/*
 * 
 */
package com.gaming.shack.core.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ShackValidationException.
 */
public class ShackValidationException extends ShackResourceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1363536734419418651L;

	/**
	 * Instantiates a new Shack validation exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public ShackValidationException(String errorCode, String message) {
		super(errorCode, message);
	}

}
