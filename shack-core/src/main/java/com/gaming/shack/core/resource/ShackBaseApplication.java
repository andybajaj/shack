/*
 * 
 */
package com.gaming.shack.core.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.gaming.shack.core.swagger.ShackSwaggerBootStrap;


/**
 * The Class JobsLibApplication.
 */

public class ShackBaseApplication extends ShackSwaggerBootStrap {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ShackBaseApplication.class);

	/**
	 * Instantiates a new jobs lib application.
	 */
	public ShackBaseApplication() {
		LOGGER.info("Called Jersey Application...");

		register(JacksonFeature.class);

		register(ShackResponseFilter.class);

		register(ShackGenericExceptionMapper.class);

		register(CORSRequestFilter.class);
		register(ShackJacksonObjectMapperProvider.class);
		register(ShackBusinessExceptionMapper.class);

	}

}
