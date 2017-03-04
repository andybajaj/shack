/*
 * 
 */
package com.gaming.shack.core.dao;

import java.util.List;

import javax.persistence.Query;

// TODO: Auto-generated Javadoc
/**
 * The Class ShackBaseDao.
 *
 * @param <T> the generic type
 */
public interface IShackBaseDao<T , I extends Object> {	
	/**
	 * 
	 * @param id
	 * @param entityClass
	 * @return
	 */
	public T findById(I id) ;
	
	/**
	 * 
	 * @param entity
	 */
	public void add(T entity) ;
	
	/**
	 * 
	 * @param entity
	 */
	public void delete(T entity); 

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 */
	public void deleteById(I id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public T getReference(I id);

	/**
	 * 
	 * @param startIndex
	 * @param maxRows
	 * @return
	 */
	public List<T> findSetOfRecords(int startIndex, int maxRows);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public T update(T entity);
	
	public T getSingleResult(Query query);
	
	/**
	 * Insert batch.
	 *
	 * @param batchEntities the batch entities
	 * @return the int
	 */
	public int insertBatch(List<T> batchEntities) ;
	
	/**
	 * Delete batch.
	 *
	 * @param batchEntities the batch entities
	 * @return the int
	 */
	public int deleteBatch(List<T> batchEntities);
	
	/**
	 * Update batch.
	 *
	 * @param batchEntities the batch entities
	 * @return the int
	 */
	public int updateBatch(List<T> batchEntities);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public T merge(T entity);
			
}
