/*
 * 
 */
package com.gaming.shack.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gaming.shack.core.enums.DataSourceType;


// TODO: Auto-generated Javadoc
/**
 * The Class ShackBaseDao.
 *
 * @param <T> the generic type
 */
public abstract class ShackBaseDao<T extends Object> {

	/** The logger. */
	protected final Logger LOGGER = LogManager.getLogger(this.getClass());

	/** The shack entity manager. */
	private EntityManager shackEntityManager;
	
	
	/**
	 * Gets the entity manager.
	 *
	 * @param dataSourceType the data source type
	 * @return the entity manager
	 */
	protected EntityManager getEntityManager(DataSourceType dataSourceType) {

		switch (dataSourceType) {
		case SHACK:
			LOGGER.debug("SHACK  Entity Manager");
			return shackEntityManager;
		default:
			return null;
		}
	}
	
	/**
	 * Sets the fetcher entity manager.
	 *
	 * @param em
	 *            the new fetcher entity manager
	 */
	@PersistenceContext(unitName = "SHACK_PU")
	public void setShackEntityManager(EntityManager em) {
		this.shackEntityManager = em;

	}

}
