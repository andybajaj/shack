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

	@Override
	public MemberMaster findMemberByEmail(String email) throws ShackDAOException {
		try {

			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("Member.findMemberById");
			query.setParameter("email", email);

			return getSingleResult(query);

		} catch (Exception e) {
			throw new ShackDAOException("MEM_DAO_ERR", "exception in findMemberByEmail", e);
		}
	}

	@Override
	public MemberMaster findMemberByCardBarCode(Long barCode) throws ShackDAOException {		
		try {
			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("Member.findMemberByCardBarCode");
			query.setParameter("barCode", barCode);

			return getSingleResult(query);

		} catch (Exception e) {
			throw new ShackDAOException("MEM_DAO_ERR", "exception in findMemberByEmail", e);
		}
	}

	@Override
	public int deleteOptinsByMMId(Long mmId) throws ShackDAOException {		
		try {
			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("Member.deleteOptinsByMMId");
			query.setParameter("mmId", mmId);
			return query.executeUpdate() ;

		} catch (Exception e) {
			throw new ShackDAOException("MEM_DAO_ERR", "exception in deleteOptinsByMMId", e);
		}

	}
		
	
}
