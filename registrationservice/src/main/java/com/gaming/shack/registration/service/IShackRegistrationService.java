/*
 * 
 */
package com.gaming.shack.registration.service;

import java.util.List;

import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.model.MemberProfileDTO;
import com.gaming.shack.data.model.UserDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface IShackRegistrationService.
 */
public interface IShackRegistrationService {
	
	/**
	 * Find all users.
	 *
	 * @return the list
	 * @throws ShackServiceException the shack service exception
	 */
	public List<UserDTO> findAllUsers() throws ShackServiceException;
	
	/**
	 * 
	 * @param memberProfile
	 * @return
	 * @throws ShackServiceException
	 */
	public MemberProfileDTO addMemberMaster(MemberProfileDTO memberProfile)
			throws ShackValidationException, ShackServiceException; 
	

}
