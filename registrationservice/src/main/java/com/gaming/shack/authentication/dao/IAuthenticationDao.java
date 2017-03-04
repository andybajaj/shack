package com.gaming.shack.authentication.dao;

import java.io.Serializable;

import com.gaming.shack.core.dao.IShackBaseDao;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.data.entity.registration.MemberAccount;
import com.gaming.shack.data.entity.registration.MemberMaster;

public interface IAuthenticationDao <T, I extends Serializable> extends IShackBaseDao<T, I>{
	
	public MemberMaster findMemberById(Long id)  throws ShackDAOException;
	
	public MemberMaster findMemberByEmailID(String emailID) throws ShackDAOException;
	
	public MemberAccount findMemberAccount(Long id) throws ShackDAOException;
	
	public int updateNoOfFailedAttempt(Long failedAttemptCount,Long memID)throws ShackDAOException;
	
	public int updateMemberStatus(String status,Long memID)throws ShackDAOException;
	
	public int updateSucessLogin(Long memID) throws ShackDAOException;

}
