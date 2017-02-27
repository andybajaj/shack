/*
 * 
 */
package com.gaming.shack.core.resource;

import javax.ws.rs.ext.ContextResolver;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

// TODO: Auto-generated Javadoc
/**
 * The Class ObjectMapperProvider.
 */
public class ShackJacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {

	/** The default object mapper. */
	final ObjectMapper defaultObjectMapper;

	/**
	 * Instantiates a new object mapper provider.
	 */
	public ShackJacksonObjectMapperProvider() {
		defaultObjectMapper = createDefaultMapper();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.ws.rs.ext.ContextResolver#getContext(java.lang.Class)
	 */
	@Override
	public ObjectMapper getContext(final Class<?> type) {

		return defaultObjectMapper;

	}

	/**
	 * Creates the default mapper.
	 *
	 * @return the object mapper
	 */
	private static ObjectMapper createDefaultMapper() {
		final ObjectMapper result = new ObjectMapper();

		result.setAnnotationIntrospector(new JacksonAnnotationIntrospector());

		result.enable(SerializationFeature.INDENT_OUTPUT);
		result.setSerializationInclusion(JsonInclude.Include.NON_NULL);

		return result;
	}
}
