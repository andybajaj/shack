package com.gaming.shack.registration.dao;

import java.io.Serializable;
import java.util.List;

import com.gaming.shack.core.dao.IShackBaseDao;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.entity.registration.MemberMaster;

public interface IMemberMasterDAO<T, I extends Serializable> extends IShackBaseDao<T, I> {
	

	public MemberMaster readBasicProfile(Long memberId) throws ShackDAOException;


	/**
	 * 
	 * @param memberId
	 * @return
	 * @throws ShackDAOException
	 */
	public MemberMaster findMemberById(Long memberId) throws ShackDAOException;
	
	/**
	 * 
	 * @param memberId
	 * @return
	 * @throws ShackDAOException
	 */
	public MemberMaster findMemberByEmail(String email) throws ShackDAOException;
	
	/**
	 * 
	 * @param cardBarCode
	 * @return
	 * @throws ShackDAOException
	 */
	public MemberMaster findMemberByCardBarCode(Long barCode) throws ShackDAOException;
	
	/**
	 * 
	 * @param mmId
	 * @return
	 * @throws ShackDAOException
	 */
	public int deleteOptinsByMMId(Long mmId) throws ShackDAOException;
	
	/**
	 * 
	 * @param optinsIds
	 * @return
	 * @throws ShackDAOException
	 */
	public int updateOptinsStatus(List<Long> optinsIds ,  String status) throws ShackDAOException;
	
}
