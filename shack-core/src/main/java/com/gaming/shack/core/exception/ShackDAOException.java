/*
 * 
 */

package com.gaming.shack.core.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class ShackDAOException.
 */
public class ShackDAOException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4399455579240242188L;

	/** The error code. */
	private final String errorCode;

	/** The error msg. */
	private final String errorMsg;

	/**
	 * Instantiates a new Shack dao exception.
	 *
	 * @param errorCode the error code
	 * @param aErrorMessage the a error message
	 * @param aTrowableObj the a trowable obj
	 */
	public ShackDAOException(String errorCode, String aErrorMessage, Throwable aTrowableObj) {
		super(aErrorMessage, aTrowableObj);
		this.errorCode = errorCode;
		this.errorMsg = aErrorMessage;

	}

	/**
	 * Instantiates a new Shack dao exception.
	 *
	 * @param errorCode the error code
	 * @param aErrorMessage the a error message
	 */
	public ShackDAOException(String errorCode, String aErrorMessage) {
		super(aErrorMessage);
		this.errorCode = errorCode;
		this.errorMsg = aErrorMessage;

	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the error msg.
	 *
	 * @return the error msg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
}
