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
import com.gaming.shack.core.model.ItemList;
import com.gaming.shack.data.model.MemberProfileDTO;
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
			LOGGER.error("101 : error occured in findAllUsers" , e) ;
			throw new ShackResourceException("101", "Error in findColsMapping");
		}
	}

	@Override
	/**
	 * Tested the service with the following pay load and working
	 * and data goign to table
	 * {
		  "firstName": "John",
		  "lastName": "Smith",
		  "middleName": "p",
		  "nameTitle": "Mr.",
		  "dateOfBirth": "1980-01-31",
		  "emailId": "john.smith@john.com",
		  "phoneNumberCountryCode": "",
		  "phoneNumber": "9876543210",
		  "preferredSite": 11,
		  "membershipType": 1,
		  "memberType": 1,
		  "parentMemberId": 123,
		  "leftHanded" : true,
		  "channelId":18 
		}
	 */
	public ItemList<MemberProfileDTO> addMemberMaster(MemberProfileDTO memberProfileIn) throws ShackResourceException {
		try {
			LOGGER.info("addMemberMaster api called");
			MemberProfileDTO memberProfile = shackRegistrationService.addMemberMaster(memberProfileIn) ; 
			ItemList<MemberProfileDTO> items = new ItemList<>();
			items.setItems(memberProfile);
			return items ;
		} catch(Exception e) {
			LOGGER.error("101 : error occured in addMemberMaster" , e) ;
			throw new ShackResourceException("101", "Error in addMemberMaster");
		}
	}
	
	
}
