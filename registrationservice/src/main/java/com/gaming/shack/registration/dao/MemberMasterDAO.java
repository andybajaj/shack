package com.gaming.shack.registration.dao;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.gaming.shack.core.dao.ShackBaseDao;

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
	
}
