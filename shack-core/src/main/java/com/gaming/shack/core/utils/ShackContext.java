/*
 * 
 */
package com.gaming.shack.core.utils;

import java.util.LinkedHashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class PxyThreadLocalContext.
 */
public class ShackContext {
	
	/** The context. */
	private  Map<String,Object> context = new LinkedHashMap<String,Object>();

	/**
	 * Gets the context.
	 * 
	 * @return the context
	 */
	public Map<String, Object> getContext() {
		return context;
	}

	/**
	 * Sets the context.
	 * 
	 * @param context
	 *            the context
	 */
	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

}
