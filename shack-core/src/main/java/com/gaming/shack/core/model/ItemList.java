/*
 * 
 */
package com.gaming.shack.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


// TODO: Auto-generated Javadoc
/**   
 * The Class ItemList.
 *
 * @param <T> the generic type
 */

public class ItemList<T> implements Serializable {
	
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The count. */

	private Integer count = 0;

	

	/** The items. */

	
	private List<T> items;
	
	/**
	 * Instantiates a new item list.
	 */
	public ItemList(){
		items = new ArrayList<T>();
	}

	/**
	 * Adds the item.
	 *
	 * @param item the item
	 */
	public void addItem(T item) {
		if (items == null) {
			items = new ArrayList<T>();
		}
		items.add(item);
	}

	/**
	 * Adds the list.
	 *
	 * @param items1 the items 1
	 */
	public void addList(List<T> items1) {
		if (items == null) {
			items = new ArrayList<T>();
		}
		for (T t : items1) {
			items.add(t);
		}

	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		if (items != null) {
			return items.size();
		}
		return 0;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	
	public Integer getCount() {
		return this.size();
	}

	

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */
	
	
	public List<T> getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items1 the new items
	 */
	public void setItems(List<T> items1) {
		if(items1 == null){
			return;
		}
		if (items == null) {
			items = new ArrayList<T>();
		}
		for (T t : items1) {
			items.add(t);
		}
		// overrides count accordingly
		if (items != null) {
			count = items.size();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemList [count=" + count + ", items=" + items + "]";
	}

	
}
