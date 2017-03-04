package com.gaming.shack.registration.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gaming.shack.core.dao.ShackBaseDao;
import com.gaming.shack.core.enums.DataSourceType;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.entity.registration.MemberMaster;

/**
 * The DAO class for the member master
 * @author shahnawf
 *
 */
@Repository
public class MemberMasterDAO extends ShackBaseDao<MemberMaster, Serializable>
		implements IMemberMasterDAO<MemberMaster, Serializable> {
	
	/**
	 * public constructor
	 */
	public MemberMasterDAO() {
		super(MemberMaster.class);
	}

	@Override
	public MemberMaster findMemberById(Long memberId) throws ShackDAOException {
		try {

			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("Member.findMemberById");
			query.setParameter("id", memberId);

			return getSingleResult(query);

		} catch (Exception e) {
			throw new ShackDAOException("MEM_DAO_ERR", "exception in findChannelById", e);
		}
	}
	
	
}
