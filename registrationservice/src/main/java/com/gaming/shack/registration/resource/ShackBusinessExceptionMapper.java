/*
 * 
 */

package com.gaming.shack.registration.resource;



import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gaming.shack.core.enums.ExitStatusType;
import com.gaming.shack.core.exception.ShackResourceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.core.model.ResponseStatus;
import com.gaming.shack.core.model.SimpleResponse;



// TODO: Auto-generated Javadoc
/**
 * The Class ShackBusinessExceptionMapper.
 */

@Provider
public class ShackBusinessExceptionMapper implements ExceptionMapper<ShackResourceException> {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ShackBusinessExceptionMapper.class);

	/** The headers. */
	protected @Context HttpHeaders headers;

	/** The uri. */
	protected @Context UriInfo uri;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(ShackResourceException ex) {
		Response response=null;
		
			LOGGER.error("logging  in Shack busienss exception mapper",ex);

			
		
			SimpleResponse<Object> simpleResp = new SimpleResponse<Object>();
			if (ex instanceof ShackValidationException) {
				
				ShackValidationException ex1=(ShackValidationException)ex;
				
				
				ResponseStatus status = new ResponseStatus(ExitStatusType.BAD_REQUEST.toString(), ex1.getErrorCode(),ex1.getMessage());
				simpleResp.setStatus(status);
				
				response= Response.status(ResponseStatus.BAD_REQUEST_ERROR).entity(simpleResp).type(MediaType.APPLICATION_JSON).build();
				
			} else  {
				
				ShackResourceException ex1=(ShackResourceException)ex;
				ResponseStatus status = new ResponseStatus(ExitStatusType.FAILED.toString(),
						Integer.toString(ResponseStatus.INTERNAL_SERVER_ERROR), ex1.getMessage());
				simpleResp.setStatus(status);
				response= Response.status(ResponseStatus.INTERNAL_SERVER_ERROR).entity(simpleResp).type(MediaType.APPLICATION_JSON).build();
			} 
		
		return response;

	}

}
