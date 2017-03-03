package com.gaming.shack.registration.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.gaming.shack.core.dao.ShackBaseDao;
import com.gaming.shack.data.entity.registration.Channel;
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
	
}
