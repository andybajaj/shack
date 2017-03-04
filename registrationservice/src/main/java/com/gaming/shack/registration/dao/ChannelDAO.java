package com.gaming.shack.registration.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gaming.shack.core.dao.ShackBaseDao;
import com.gaming.shack.core.enums.DataSourceType;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.entity.registration.Channel;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.entity.registration.SiteMaster;

/**
 * The DAO class for the member master
 * @author shahnawf
 *
 */
@Repository
public class ChannelDAO extends ShackBaseDao<Channel, Serializable>
		implements IChannelDAO<Channel, Serializable> {
	
	/**
	 * public constructor
	 */
	public ChannelDAO() {
		super(Channel.class);
	}

	@Override
	public Channel findChannelById(Long channelId) throws ShackDAOException {
		try {

			EntityManager em = getEntityManager(DataSourceType.SHACK);
			Query query = em.createNamedQuery("Channel.findChannelById");
			query.setParameter("channelId", channelId);

			return getSingleResult(query);

		} catch (Exception e) {
			throw new ShackDAOException("CHAN_DAO_ERR", "exception in findChannelById", e);
		}
	}
	
}
