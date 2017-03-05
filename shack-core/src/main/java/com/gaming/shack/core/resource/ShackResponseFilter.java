/*
 * 
 */

package com.gaming.shack.core.resource;



import java.io.File;

import javax.annotation.Priority;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gaming.shack.core.model.ItemList;
import com.gaming.shack.core.model.ResponseStatus;
import com.gaming.shack.core.model.SimpleResponse;
import com.gaming.shack.core.utils.Log4ThreadContext;

import io.swagger.models.Swagger;

// TODO: Auto-generated Javadoc
/**
 * The Class JobsLibMessageHandler.
 */
@Provider
@Priority(1)
public class ShackResponseFilter implements ContainerResponseFilter {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ShackResponseFilter.class);
	
	

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.container.ContainerResponseFilter#filter(javax.ws.rs.
	 * container.ContainerRequestContext,
	 * javax.ws.rs.container.ContainerResponseContext)
	 */
	// @Override
	@Override

	public void filter(ContainerRequestContext inContext, ContainerResponseContext outContext) {
		
		LOGGER.info("response filter invoked");
		
		MultivaluedMap<String, Object> headers = outContext.getHeaders();
		 
		headers.add("Access-Control-Allow-Origin", "*");
		
		headers.add("Access-Control-Allow-Headers", "origin, content-type, accept,crossdomain");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		headers.add("Access-Control-Max-Age", "1209600");
		LOGGER.info("CORS Response Headers Added");
        
		try {
			Object entity = outContext.getEntity();
			
			if(entity==null){
				return;
			}
			if(entity instanceof Swagger){
				return;
			}
			if(entity instanceof File){
				return;
			}
			if (entity instanceof SimpleResponse) {
				LOGGER.info("simple response object returned ");
				return;
			}
			
			

			SimpleResponse simpleResp = new SimpleResponse();
			simpleResp.setStatus(ResponseStatus.OK);

			if (entity instanceof ItemList<?>) {
				ItemList<?> itemList = (ItemList<?>) entity;
				simpleResp.setItems(itemList);
			} else {

				
				ItemList itemList = new ItemList();
				if (entity != null) {
					itemList.addItem(entity);
					
				}
				simpleResp.setItems(itemList);

			}
			outContext.setEntity(simpleResp, outContext.getEntityAnnotations(), MediaType.APPLICATION_JSON_TYPE);
			
			LOGGER.info("response filter processing done ");
		} finally{
			Log4ThreadContext.removeFishTagging();
		}
		
	}

}
