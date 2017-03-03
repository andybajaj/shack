/*
 * 
 */
package com.gaming.shack.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.data.model.MemberProfileDTO;
import com.gaming.shack.data.model.UserDTO;
import com.gaming.shack.registration.dao.IShackResgistrationDao;
import com.gaming.shack.registration.util.RegistrationHelper;
// TODO: Auto-generated Javadoc

/**
 * The Class ShackRegistrationService.
 */
@Service
public class ShackRegistrationService implements IShackRegistrationService {
	
	/** The shack resgistration dao. */
	@Autowired
	private IShackResgistrationDao shackResgistrationDao;
	
	@Autowired
	RegistrationHelper registrationhelper ;

	/* (non-Javadoc)
	 * @see com.gaming.shack.registration.service.IShackRegistrationService#findAllUsers()
	 */
	@Override
	public List<UserDTO> findAllUsers() throws ShackServiceException {
		// TODO Auto-generated method stub
		try {
			return shackResgistrationDao.findAllUser();
		} catch (ShackDAOException e) {
			throw new ShackServiceException("101","exception in find all users");
		}
	}


	@Override
	public MemberProfileDTO addMemberMaster(MemberProfileDTO memberProfile) throws ShackServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
