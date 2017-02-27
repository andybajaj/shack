/*
 * 
 */
package com.gaming.shack.core.utils;

import java.util.Map;




// TODO: Auto-generated Javadoc
/**
 * The Class PxyThreadLocal.
 */
public class ShackThreadLocal extends ThreadLocal<ShackContext> {
	
	
	/** The cache thread local. */
	private static ThreadLocal<ShackContext> cacheThreadLocal =
		    new ThreadLocal<ShackContext>() {
		      protected ShackContext initialValue() {
		        return new ShackContext();
		      }
	};

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public static ShackContext getValue() {
		return (ShackContext)cacheThreadLocal.get();
	}

	
	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public static void setValue(ShackContext value) {
		cacheThreadLocal.set(value);
	}
	
	/**
	 * Gets the context value.
	 * 
	 * @param key
	 *            the key
	 * @return the context value
	 */
	public static String getContextValue(String key) {
		ShackContext context = (ShackContext)cacheThreadLocal.get();
		return context.getContext().get(key);
	}
	
	/**
	 * Gets the context.
	 * 
	 * @return the context
	 */
	public static Map<String,String> getContext() {
		ShackContext context = (ShackContext)cacheThreadLocal.get();
		return context.getContext();
	}
	
	/**
	 * Sets the context value.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public static void setContextValue(String key, String value) {
		ShackContext context = (ShackContext)cacheThreadLocal.get();
		context.getContext().put(key, value);
	}
	
	/**
	 * Sets the context value.
	 * 
	 * @param map
	 *            the map
	 */
	public static void setContextValue(Map<String,String> map) {
		ShackContext context = (ShackContext)cacheThreadLocal.get();
		context.getContext().putAll(map);
	}
	
	/**
	 * Removes the context param.
	 * 
	 * @param key
	 *            the key
	 */
	public static void removeContextParam(String key) {
		ShackContext context = (ShackContext)cacheThreadLocal.get();
		context.getContext().remove(key);
	}

	
	/**
	 * Removes the value.
	 */
	public static void removeValue() {
		cacheThreadLocal.remove();
	}
	
}
