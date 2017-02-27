/*
 * 
 */

package com.gaming.shack.core.resource;



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
import com.gaming.shack.core.model.ResponseStatus;
import com.gaming.shack.core.model.SimpleResponse;




// TODO: Auto-generated Javadoc
/**
 * The Class JobsLibExceptionMapper.
 */

@Provider
public class ShackGenericExceptionMapper implements ExceptionMapper<Throwable> {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ShackGenericExceptionMapper.class);

	/** The ctx. */
	protected @Context UriInfo uri;
	
	/** The headers. */
	@Context
    private HttpHeaders headers;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.ExceptionMapper#toResponse(java.lang.Throwable)
	 */
	@Override
	public Response toResponse(Throwable ex) {
		LOGGER.error("logging  in shack exception mapper",ex);
		
		
		
		SimpleResponse<Object> simpleResp = new SimpleResponse<Object>();
		ResponseStatus status = new ResponseStatus( ExitStatusType.FAILED.toString(),Integer.toString(ResponseStatus.INTERNAL_SERVER_ERROR),ex.getMessage());
		simpleResp.setStatus(status);
		return Response.status(ResponseStatus.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).entity(simpleResp).build();
	}

}
