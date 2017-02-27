/*
 * 
 */
package com.gaming.shack.registration.resource;










import javax.ws.rs.ApplicationPath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gaming.shack.core.resource.ShackBaseApplication;

// TODO: Auto-generated Javadoc
/**
 * The Class JobsLibApplication.
 */
@ApplicationPath("/v1/*")
public class ShackRegistrationApplication extends ShackBaseApplication {
	
	
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ShackRegistrationApplication.class);
	
	
	
	/**
	 * Instantiates a new shack registration application.
	 */
	public ShackRegistrationApplication() {
		super();
		LOGGER.info("Shack Registration Jersey application");
        register(ShackRegistrationResource.class);
       
    }
}
