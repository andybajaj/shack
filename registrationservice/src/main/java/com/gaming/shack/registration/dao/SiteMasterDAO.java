package com.gaming.shack.registration.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.gaming.shack.core.dao.ShackBaseDao;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.entity.registration.SiteMaster;

/**
 * The DAO class for the member master
 * @author shahnawf
 *
 */
@Repository
public class SiteMasterDAO extends ShackBaseDao<SiteMaster, Serializable>
		implements ISiteMasterDAO<SiteMaster, Serializable> {
	
	/**
	 * public constructor
	 */
	public SiteMasterDAO() {
		super(SiteMaster.class);
	}
	
}
