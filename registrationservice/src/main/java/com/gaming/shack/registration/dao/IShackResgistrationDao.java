/*
 * 
 */

package com.gaming.shack.registration.dao;

import java.util.List;

import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.model.UserDTO;


// TODO: Auto-generated Javadoc
/**
 * The Interface IShackResgistrationDao.
 */
public interface IShackResgistrationDao {

	
	/**
	 * Find all user.
	 *
	 * @return the list
	 * @throws ShackDAOException the shack DAO exception
	 */
	public List<UserDTO> findAllUser() throws ShackDAOException;
	
	

}
