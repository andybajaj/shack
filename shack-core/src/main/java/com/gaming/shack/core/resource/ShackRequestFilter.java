/*
 * 
 */

package com.gaming.shack.core.resource;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gaming.shack.core.utils.Log4ThreadContext;

// TODO: Auto-generated Javadoc
/**
 * The Class JobsLibMessageHandler.
 */
@Provider
@Priority(1)
public class ShackRequestFilter implements  ContainerRequestFilter {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ShackRequestFilter.class);
	
	/** The headers. */
	@Context
    private HttpHeaders headers;
	
	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container.ContainerRequestContext)
	 */
	public void filter( ContainerRequestContext requestCtx ) throws IOException {
		
 
		Log4ThreadContext.addFishTagging(requestCtx.getUriInfo().getPath());
		LOGGER.info( "Executing REST request filter" );
        // When HttpMethod comes as OPTIONS, just acknowledge that it accepts...
     
    }
}
