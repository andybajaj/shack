/*
 * 
 */

package com.gaming.shack.registration.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gaming.shack.core.dao.ShackBaseDao;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.entity.registration.User;
import com.gaming.shack.data.model.UserDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class HoldingRefDataDao.
 */
@Repository
public class ShackResgistrationDao extends ShackBaseDao<User , Serializable> implements IShackResgistrationDao {

	
	public ShackResgistrationDao() {
		super(User.class) ;
	}
	
	/* (non-Javadoc)
	 * @see com.gaming.shack.registration.dao.IShackResgistrationDao#findAllUser()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<UserDTO> findAllUser() throws ShackDAOException {
		List<UserDTO> userDTOLst = null;
		try {
			EntityManager em = getEntityManager(com.gaming.shack.core.enums.DataSourceType.SHACK);
			Query query = em.createNamedQuery("User.findAll");
			

			userDTOLst = (List<UserDTO>) query.getResultList();

		} catch (Exception e) {
			LOGGER.error("exception in findAllUser", e);
			throw new ShackDAOException("101", "exception in findAllUser...", e);
		}
		return userDTOLst;
	}

	
	
}
