/*
 * 
 */
package com.gaming.shack.core.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.gaming.shack.core.enums.DataSourceType;

// TODO: Auto-generated Javadoc
/**
 * The Class ShackBaseDao.
 *
 * @param <T>
 *            the generic type
 */
public class ShackBaseDao<T, I extends Serializable> implements IShackBaseDao<T, I> {

	/** The logger. */
	protected final Logger LOGGER = LogManager.getLogger(this.getClass());
	
	protected static final int BATCH_UPDATE_SIZE=100;
	
	/** The shack entity manager. */
	private EntityManager shackEntityManager;

	private Class<T> entityClass;

	public ShackBaseDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Gets the entity manager.
	 *
	 * @param dataSourceType
	 *            the data source type
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

	protected EntityManager getEntityManager() {
		return shackEntityManager;
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

	/**
	 * 
	 * @param id
	 * @param entityClass
	 * @return
	 */
	public T findById(I id) {
		EntityManager manager = getEntityManager(DataSourceType.SHACK);
		return manager.find(entityClass, id);
	}

	@Override
	public void add(T entity) {
		getEntityManager(DataSourceType.SHACK).persist(entity);

	}

	@Override
	public void delete(T entity) {
		T t = getEntityManager().contains(entity) ? entity : getEntityManager().merge(entity);
		getEntityManager().remove(t);
	}

	@Override
	public void deleteById(I id) {
		delete(findById(id));
	}

	public T getReference(I id) {
		return getEntityManager().getReference(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findSetOfRecords(int startIndex, int maxRows) {
		Query query = getEntityManager().createQuery("select e from " + getEntityName() + " e");
		query.setFirstResult(startIndex - 1);
		query.setMaxResults(maxRows);
		return query.getResultList();
	}
	
	@Override
    public T update(T entity) {
        return merge(entity);
    }
	
	@Override
    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }
	
	@Override
	public int insertBatch(List<T> batchEntities) {
		int count = 0 ;
		
		for (T entity : batchEntities) {
			count ++ ;
			persist(entity);
			if(count % BATCH_UPDATE_SIZE == 0){
				getEntityManager().flush();
				getEntityManager().clear();
			}
		}
		
		if(count % BATCH_UPDATE_SIZE != 0){
			getEntityManager().flush();
			getEntityManager().clear();
		}
		
		return count ;
	}
	
	public void persist(T entity) {
		getEntityManager().persist(entity);
    }
	
	@Override
	public int updateBatch(List<T> batchEntities) {
		int count = 0 ;
		
		for (T entity : batchEntities) {
			count ++ ;
			entity=merge(entity);
			if(count % BATCH_UPDATE_SIZE == 0){
				getEntityManager().flush();
				getEntityManager().clear();
			}
		}
		
		if(count % BATCH_UPDATE_SIZE != 0){
			getEntityManager().flush();
			getEntityManager().clear();
		}
		
		return count ;
	}
	public String getEntityName() {
		return entityClass.getSimpleName();
	}

	@Override
	public int deleteBatch(List<T> batchEntities) {
		int count = 0 ;
		
		for (T entity : batchEntities) {
			count ++ ;
			delete(entity);
			if(count % BATCH_UPDATE_SIZE == 0){
				getEntityManager().flush();
				getEntityManager().clear();
			}
		}
		
		if(count % BATCH_UPDATE_SIZE != 0){
			getEntityManager().flush();
			getEntityManager().clear();
		}
		
		return count ;
	}


}
