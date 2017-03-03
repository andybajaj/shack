package com.gaming.shack.registration.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.gaming.shack.core.utils.DateFormatterUtils;
import com.gaming.shack.data.entity.registration.Channel;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.entity.registration.SiteMaster;
import com.gaming.shack.data.model.MemberProfileDTO;

/**
 * The helper class for the registration
 * @author shahnawf
 *
 */
@Component
public class RegistrationHelper {
	
	/**
	 * 
	 * @param memberProfile
	 * @return
	 */
	public MemberMaster createMemberMaster(MemberProfileDTO memberProfile) {
		MemberMaster entity = new MemberMaster() ;		
		entity.setMemberID(memberProfile.getParentMemberId());
		entity.setNameTitle(memberProfile.getNameTitle());
		entity.setGivenName(memberProfile.getFirstName());
		entity.setSurname(memberProfile.getLastName());																			
		entity.setDateOfBirth(DateFormatterUtils.toDate(memberProfile.getDateOfBirth()));
		entity.setCreateBy("Shah");
		entity.setEmailaddress(memberProfile.getEmailId());
		entity.setUpdateBy("Shah");				
		entity.setUpdateBy("Shah");
		entity.setParentMemberID(memberProfile.getParentMemberId());
		
		return entity ;
	}
}
