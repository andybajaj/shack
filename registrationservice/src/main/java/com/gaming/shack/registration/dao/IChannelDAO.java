package com.gaming.shack.registration.dao;

import java.io.Serializable;

import com.gaming.shack.core.dao.IShackBaseDao;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.entity.registration.Channel;

/**
 * 
 * @author shahnawf
 *
 * @param <T>
 * @param <I>
 */
public interface IChannelDAO<T, I extends Serializable> extends IShackBaseDao<T, I> {
	
	public Channel findChannelById(Long channelId) throws ShackDAOException;
}
