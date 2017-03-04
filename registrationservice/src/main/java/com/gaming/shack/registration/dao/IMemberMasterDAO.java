package com.gaming.shack.registration.dao;

import java.io.Serializable;

import com.gaming.shack.core.dao.IShackBaseDao;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.entity.registration.MemberMaster;

public interface IMemberMasterDAO<T, I extends Serializable> extends IShackBaseDao<T, I> {
	
	public MemberMaster readBasicProfile(Long memberId) throws ShackDAOException;

}
