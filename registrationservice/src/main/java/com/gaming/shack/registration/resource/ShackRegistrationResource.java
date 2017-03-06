/*
 * 
 */
package com.gaming.shack.registration.resource;

import java.util.List;

import javax.ws.rs.core.UriInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaming.shack.core.exception.ShackResourceException;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.core.model.ItemList;
import com.gaming.shack.data.model.MemberDTO;
import com.gaming.shack.data.model.MemberSuccess;
import com.gaming.shack.data.model.UserDTO;
import com.gaming.shack.registration.service.IShackRegistrationService;

/**
 * The Class ShackRegistrationResource.
 */
@Service("shackRegistrationResource")
public class ShackRegistrationResource implements IShackRegistrationResource {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ShackRegistrationResource.class);

	/** The holding ref data service. */
	@Autowired
	private IShackRegistrationService shackRegistrationService;

	@Override
	public ItemList<UserDTO> findAllUsers(UriInfo ui) throws ShackResourceException {
		try {
			LOGGER.info("findAllUsers api called");
			List<UserDTO> userDTOLst = shackRegistrationService.findAllUsers();
			ItemList<UserDTO> items = new ItemList<>();
			items.setItems(userDTOLst);
			return items;
		} catch (ShackServiceException e) {
			LOGGER.error("101 : error occured in findAllUsers", e);
			throw new ShackResourceException("101", "Error in findColsMapping");
		}
	}

	@Override	
	public ItemList<MemberSuccess> addMemberMaster(MemberDTO memberIn) throws ShackValidationException , ShackResourceException {
		try {
			LOGGER.info("addMemberMaster api called");
			MemberSuccess member = shackRegistrationService.addMemberMaster(memberIn) ; 
			
			ItemList<MemberSuccess> items = new ItemList<MemberSuccess>();			
			items.setItems(member);
			return items;
						
		} catch(ShackValidationException sve) {
			throw sve ;
		} 
		catch(Exception e) {			
			throw new ShackResourceException("101", "Error in addMemberMaster" ,e);
		}
	
	}

	@Override
	public ItemList<MemberSuccess> updateMemberMaster(MemberDTO memberIn)
			throws ShackValidationException, ShackResourceException {
		try {
			LOGGER.info("addMemberMaster api called");
			MemberSuccess member = shackRegistrationService.addMemberMaster(memberIn) ; 
			
			ItemList<MemberSuccess> items = new ItemList<MemberSuccess>();			
			items.setItems(member);
			return items;
						
		} catch(ShackValidationException sve) {
			throw sve ;
		} 
		catch(Exception e) {			
			throw new ShackResourceException("101", "Error in addMemberMaster" ,e);
		}
	}
}
