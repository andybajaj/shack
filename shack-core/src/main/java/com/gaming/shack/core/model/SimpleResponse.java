/*
 * 
 */

package com.gaming.shack.core.model;

import java.io.Serializable;
  
// TODO: Auto-generated Javadoc
/**
 * The Class SimpleResponse.
 *
 * @param <T> the generic type
 */
public class SimpleResponse<T> implements Serializable {
	
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The status. */
	private ResponseStatus status;
	
	
	

	// may need requestQuery in here
	/** The items. */

	
	private ItemList<T> items;
	
	/**
	 * Instantiates a new simple response.
	 */
	public SimpleResponse(){
		
	}

	/**
	 * Gets the items.
	 *
	 * @return the items
	 */

	
	public ItemList<T> getItems() {
		return items;
	}

	/**
	 * Sets the items.
	 *
	 * @param items the new items
	 */
	public void setItems(ItemList<T> items) {
		this.items = items;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public ResponseStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SimpleResponse [status=" + status + ", items=" + items + "]";
	}
}
