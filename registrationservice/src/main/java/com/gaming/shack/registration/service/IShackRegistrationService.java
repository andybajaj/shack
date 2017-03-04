/*
 * 
 */
package com.gaming.shack.registration.service;

import java.util.List;

import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.model.MemberDTO;
import com.gaming.shack.data.model.UserDTO;

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
	 * @param member
	 * @return
	 * @throws ShackValidationException
	 * @throws ShackServiceException
	 */
	public MemberDTO addMemberMaster(MemberDTO member)
			throws ShackValidationException, ShackServiceException; 
	

}
