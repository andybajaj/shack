package com.gaming.shack.authentication.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gaming.shack.core.annotation.ShackNewTX;
import com.gaming.shack.core.dao.ShackBaseDao;
import com.gaming.shack.core.enums.DataSourceType;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.entity.registration.MemberAccount;
import com.gaming.shack.data.entity.registration.MemberActivation;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.enums.MemberStatusEnum;

@Repository
public class AuthenticationDao extends ShackBaseDao<Serializable, Serializable>
		implements IAuthenticationDao<Serializable, Serializable> {

	public AuthenticationDao() {
		super(Serializable.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public MemberMaster findMemberById(Long id) throws ShackDAOException {

		try {

			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("Member.findMemberById");
			query.setParameter("id", id);

			return (MemberMaster) getSingleResult(query);

		} catch (Exception e) {
			throw new ShackDAOException("AUTH_DAO_ERR", "exception in findMemberById...", e);
		}

	}

	@Override
	public MemberMaster findMemberByEmailID(String emailID) throws ShackDAOException {

		try {
			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("Member.findMemberByEmail");
			query.setParameter("email", emailID);

			return (MemberMaster) getSingleResult(query);
		} catch (Exception e) {
			LOGGER.error("exception in findMemberByEmailID", e);
			throw new ShackDAOException("AUTH_DAO_ERR", "exception in findMemberByEmailID...", e);
		}

	}

	@Override
	public MemberAccount findMemberAccount(Long memId) throws ShackDAOException {

		try {
			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("MemberAccount.findMemberAccountById");
			query.setParameter("memId", memId);

			return (MemberAccount) getSingleResult(query);
		} catch (Exception e) {
			LOGGER.error("exception in findMemberAccount", e);
			throw new ShackDAOException("AUTH_DAO_ERR", "exception in findMemberAccount...", e);
		}

	}

	@ShackNewTX
	@Override
	public int updateNoOfFailedAttempt(Long failedAttemptCount, Long memID) throws ShackDAOException {
		try {
			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("MemberAccount.updateNoOfFailedAttempt");
			query.setParameter("memId", memID);
			query.setParameter("noOffailedAttempts", failedAttemptCount);

			return query.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("exception in updateNoOfFailedAttempt", e);
			throw new ShackDAOException("AUTH_DAO_ERR", "exception in updateNoOfFailedAttempt...", e);
		}
	}

	@ShackNewTX
	@Override
	public int updateSucessLogin(Long memID) throws ShackDAOException {
		try {
			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("MemberAccount.updateSucessLogin");
			query.setParameter("memId", memID);
		
			return query.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("exception in updateNoOfFailedAttempt", e);
			throw new ShackDAOException("AUTH_DAO_ERR", "exception in updateNoOfFailedAttempt...", e);
		}
	}

	@ShackNewTX
	@Override
	public int updateMemberStatus(MemberStatusEnum status, Long memID) throws ShackDAOException {
		try {
			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("Member.updateMemberStatus");
			query.setParameter("memId", memID);
			query.setParameter("status", status);

			return query.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("exception in updateNoOfFailedAttempt", e);
			throw new ShackDAOException("AUTH_DAO_ERR", "exception in updateMemberStatus...", e);
		}
	}
	
	@ShackNewTX
	@Override
	public MemberActivation findMemberActivByUniqueId(String uniqueId) throws ShackDAOException {
		try {
			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("MemberActivation.findMemberActivationByUniqueID");
			query.setParameter("uniqueId", uniqueId);
			
			return (MemberActivation) getSingleResult(query);
			
		} catch (Exception e) {
			LOGGER.error("exception in findMemberActivByUniqueId", e);
			throw new ShackDAOException("AUTH_DAO_ERR", "exception in findMemberActivByUniqueId...", e);
		}
	}
}
