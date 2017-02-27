/*
 * 
 */

package com.gaming.shack.core.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.ThreadContext;

// TODO: Auto-generated Javadoc
/**
 * The Class NDCUtil.
 */
public class Log4ThreadContext {

	/**
	 * Instantiates a new NDC util.
	 */
	private Log4ThreadContext() {

	}

	/**
	 * Adds the fish tagging.
	 *
	 * @param ids the ids
	 */
	public static void addFishTagging(String... ids) {
		for (String id : ids) {
			ThreadContext.push(id);
			
		}

	}
	
	/**
	 * Adds the fish tagging.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public static void addFishTagging(String key, String value) {
	
			ThreadContext.put(key,value);
			
		

	}
	
	/**
	 * Gets the fish tagging.
	 *
	 * @param key the key
	 * @return the fish tagging
	 */
	public static String getFishTagging(String key) {
		
		return ThreadContext.get(key);
		
	

}

	/**
	 * Removes the last last fish tagging.
	 */
	public static void removeLastLastFishTagging() {
		if (!ThreadContext.peek().isEmpty()) {
			ThreadContext.pop();
		}

	}

	/**
	 * Gets the transaction unique id.
	 *
	 * @return the transaction unique id
	 */
	public static String getTransactionUniqueId() {
		List<String> lst = new ArrayList<String>();
		while (!ThreadContext.peek().isEmpty()) {
			lst.add(ThreadContext.pop());
		}
		Collections.reverse(lst);
		StringBuilder builder = new StringBuilder();
		for (String ndc : lst) {
			builder.append(',');
			builder.append(ndc);
			ThreadContext.push(ndc);
		}
		builder.delete(0, 1);
		return builder.toString();

	}

	/**
	 * Removes the fish tagging.
	 */
	public static void removeFishTagging() {
		ThreadContext.clearStack();
	}

}
