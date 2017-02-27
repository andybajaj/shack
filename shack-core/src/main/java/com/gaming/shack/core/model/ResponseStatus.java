/*
 * 
 */
package com.gaming.shack.core.model;

import java.io.Serializable;

import javax.ws.rs.core.Response;

import com.gaming.shack.core.enums.ExitStatusType;



// TODO: Auto-generated Javadoc
/**
 * The Class ResponseStatus.
 */
public class ResponseStatus implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2664808208144959466L;

	/** The Constant OK. */
	public static final ResponseStatus OK = new ResponseStatus(ExitStatusType.SUCCESS.toString(),Integer.toString(Response.Status.OK.getStatusCode()),
			Response.Status.OK.toString());

	/** The Constant INTERNAL_SERVER_ERROR. */
	public static final int INTERNAL_SERVER_ERROR = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
	
	/** The Constant BAD_REQUEST_ERROR. */
	public static final int BAD_REQUEST_ERROR = Response.Status.BAD_REQUEST.getStatusCode();

	

	

	/** The exit status. */
	private String exitStatus;
	
	/** The exit code. */
	private String exitCode;

	/** The error msg. */
	private String errorMsg;
	
	/**
	 * Instantiates a new response status.
	 */
	public ResponseStatus() {
	}
	

	/**
	 * Instantiates a new response status.
	 *
	 * @param exitStatus the exit status
	 * @param exitCode the exit code
	 * @param errorMsg the error msg
	 */
	public ResponseStatus(String exitStatus,String exitCode, String errorMsg) {
		super();
		this.exitStatus = exitStatus;
		this.exitCode = exitCode;
		this.errorMsg = errorMsg;
	}
	
	/**
	 * Instantiates a new response status.
	 *
	 * @param exitCode the exit code
	 * @param errorMsg the error msg
	 */
	public ResponseStatus(String exitCode, String errorMsg) {
		super();
		this.exitCode = exitCode;
		this.errorMsg = errorMsg;
	}

	/**
	 * Gets the exit status.
	 *
	 * @return the exit status
	 */
	public String getExitStatus() {
		return exitStatus;
	}

	/**
	 * Sets the exit status.
	 *
	 * @param exitStatus the new exit status
	 */
	public void setExitStatus(String exitStatus) {
		this.exitStatus = exitStatus;
	}

	/**
	 * Gets the exit code.
	 *
	 * @return the exit code
	 */
	public String getExitCode() {
		return exitCode;
	}

	/**
	 * Sets the exit code.
	 *
	 * @param exitCode the new exit code
	 */
	public void setExitCode(String exitCode) {
		this.exitCode = exitCode;
	}

	/**
	 * Gets the error msg.
	 *
	 * @return the error msg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Sets the error msg.
	 *
	 * @param errorMsg the new error msg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseStatus [exitStatus=" + exitStatus + ", exitCode=" + exitCode + ", errorMsg=" + errorMsg + "]";
	}

}
