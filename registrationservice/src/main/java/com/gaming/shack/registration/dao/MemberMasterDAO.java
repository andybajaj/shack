package com.gaming.shack.registration.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gaming.shack.core.dao.ShackBaseDao;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.model.UserDTO;

/**
 * The DAO class for the member master
 * @author shahnawf
 *
 */
@Repository
public class MemberMasterDAO extends ShackBaseDao<MemberMaster, Serializable>
		implements IMemberMasterDAO<MemberMaster, Serializable> {
	
	@Override
	public MemberMaster readBasicProfile(Long memberId) throws ShackDAOException{
		
		MemberMaster memberMaster = null;
		try {
			EntityManager em = getEntityManager(com.gaming.shack.core.enums.DataSourceType.SHACK);
			Query query = em.createNamedQuery("MemberMaster.readBasicProfile");
			
            query.setParameter("memberID", memberId);
			memberMaster = (MemberMaster) query.getSingleResult();

		} catch (Exception e) {
			LOGGER.error("exception in readBasicProfile", e);
			throw new ShackDAOException("101", "exception in readBasicProfile...", e);
		}
		return memberMaster;
	}

	/**
	 * public constructor
	 */
	public MemberMasterDAO() {
		super(MemberMaster.class);
	}
	
}
