/*
 * 
 */

package com.gaming.shack.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class SpringApplicationContext.
 */
@Component
public class SpringApplicationContext implements ApplicationContextAware{

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(SpringApplicationContext.class);

	/*
	 * This attribute holds the spring application context object.
	 */
	/** The application context. */
	private static transient ApplicationContext applicationContext = null;

	

	/**
	 * Instantiates a new spring util.
	 */
	private SpringApplicationContext() {

	}



	/**
	 * Gets the application context.
	 *
	 * @return the application context
	 */
	public  static ApplicationContext getApplicationContext() {
		

		
		return applicationContext;
	}
	
	
	
	/**
	 * setApplicationContext.
	 *
	 * @param applicationContext1 the new application context
	 * @throws BeansException the beans exception
	 */
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext1)
			throws BeansException {
		LOGGER.info("App context set up....{}",applicationContext1);
		SpringApplicationContext.applicationContext = applicationContext1;
		
	}

	/**
	 * Gets the bean.
	 *
	 * @param className the class name
	 * @return the bean
	 */
	public static Object getBean(String className) {

		
		return applicationContext.getBean(className);
	}

	/**
	 * Gets the bean.
	 *
	 * @param <T> the generic type
	 * @param requiredType the required type
	 * @return the bean
	 */
	public static <T> Object getBean(Class<T> requiredType) {
		return getBean(requiredType.getName());

	}

}
