/*
 * 
 */
package com.gaming.shack.core.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// TODO: Auto-generated Javadoc
/**
 * The Class ShackResourceException.
 */
public class ShackResourceException  extends Exception {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ShackResourceException.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8302263377555388378L;

	/** The error code. */
	private final String errorCode;

	/** The exception msg. */
	private final String exceptionMsg;

	/**
	 * Instantiates a new Shack resource exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ShackResourceException(String message, Throwable cause) {
		super(message, cause);
		this.exceptionMsg = message;
		this.errorCode = "101";
	}

	/**
	 * Instantiates a new Shack resource exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 * @param cause the cause
	 */
	public ShackResourceException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.exceptionMsg = message;
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new Shack resource exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public ShackResourceException(String errorCode, String message) {
		super(message);
		this.exceptionMsg = message;
		this.errorCode = errorCode;
	}

	/**
	 * Instantiates a new Shack resource exception.
	 *
	 * @param message the message
	 */
	public ShackResourceException(String message) {
		super(message);
		this.errorCode = "101";
		this.exceptionMsg = message;
	}

	/**
	 * Gets the error message.
	 *
	 * @param e the e
	 * @param aErrMsg the a err msg
	 * @return the error message
	 */
	public static String getErrorMessage(Throwable e, String aErrMsg) {
		try {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			if (aErrMsg != null) {
				StringBuilder strBldr = new StringBuilder();
				strBldr.append(aErrMsg);
				strBldr.append("  :: ");
				strBldr.append(sw.toString());
				return strBldr.toString();
			}

			return sw.toString();
		} catch (Exception e2) {
			LOGGER.error("exception in getErrorMessage", e2);
		}
		return "Stacktrace to string not working";
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/**
	 * Gets the exception msg.
	 *
	 * @return the exception msg
	 */
	public String getExceptionMsg() {
		return this.exceptionMsg;
	}

}
