/*
 * 
 */

package com.gaming.shack.core.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.io.Resource;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyLoader.
 */

public class PropertyLoader {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyLoader.class);

	/** The resources. */
	private List<Resource> resources;

	/** The bag. */
	private static Map<Object, Object> bag = null;

	/**
	 * Instantiates a new property loader.
	 */
	public PropertyLoader() {
	}

	/**
	 * Instantiates a new property loader.
	 *
	 * @param resources the resources
	 */
	public PropertyLoader(List<Resource> resources) {
		this.resources = resources;
	}

	/**
	 * Load properties.
	 */

	public void loadProperties() {
		Properties config = null;
		try {
			for (Resource res : resources) {

				if (config == null) {
					config = new Properties();
				}

				try (InputStream is = res.getInputStream();) {
					config.load(is);
				}
				if (config != null && !config.isEmpty()) {
					Map<Object, Object> property = config;
					bag = new HashMap<>(property);

				}
			}

		} catch (FileNotFoundException e) {
			LOGGER.warn("file not found ", e);
		}

		catch (IOException e) {
			LOGGER.warn("Property file load exception...", e);
		}
	}

	/**
	 * Gets the property.
	 *
	 * @param key the key
	 * @return the property
	 */
	public String getProperty(String key) {
		String propertyVal = "";
		try {
			propertyVal = bag == null ? null : (String) bag.get(key);
		} catch (NoSuchMessageException noSuchMessageException) {
			LOGGER.error("Error in ", noSuchMessageException);
		}
		return propertyVal;

	}

	/**
	 * Gets the resources.
	 *
	 * @return the resources
	 */
	public List<Resource> getResources() {
		return resources;
	}

	/**
	 * Sets the resources.
	 *
	 * @param resources the new resources
	 */
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

}
