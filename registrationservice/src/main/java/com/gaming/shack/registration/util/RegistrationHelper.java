package com.gaming.shack.registration.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gaming.shack.core.constants.ShackResourceConstants;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.utils.DateFormatterUtils;
import com.gaming.shack.data.entity.registration.Address;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.entity.registration.OptIn;
import com.gaming.shack.data.enums.AddressType;
import com.gaming.shack.data.enums.MemberStatusEnum;
import com.gaming.shack.data.enums.OptionInType;
import com.gaming.shack.data.model.MemberAddressDTO;
import com.gaming.shack.data.model.MemberDTO;
import com.gaming.shack.data.model.MemberDetailsDTO;
import com.gaming.shack.data.model.MemberProfileDTO;
import com.gaming.shack.data.model.OptInDTO;

/**
 * The helper class for the registration
 * 
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
	public MemberMaster createMemberMaster(MemberDTO member) throws  ShackServiceException {
		
		try {
			MemberProfileDTO memberProfile = member.getMemberProfile();
	
			MemberMaster entity = new MemberMaster();
			entity.setMemberID(memberProfile.getMemberId());
			entity.setNameTitle(memberProfile.getNameTitle());
			entity.setGivenName(memberProfile.getFirstName());
			entity.setSurname(memberProfile.getLastName());
			entity.setDateOfBirth(DateFormatterUtils.toDate(memberProfile.getDateOfBirth()));
			entity.setCreateBy(RegistrationUtil.getLoggedInUserId());
			entity.setEmailaddress(memberProfile.getEmailId());
			entity.setUpdateBy(RegistrationUtil.getLoggedInUserId());
			entity.setParentMemberID(memberProfile.getParentMemberId());
			entity.setMemberTypeID(new Long(memberProfile.getMemberType()));
			entity.setTCTemplateID(memberProfile.getTcTemplateId());
			entity.setCardBarCode(memberProfile.getCardBarCode());
			entity.setMemberStatus(MemberStatusEnum.P);
			entity.setMemberID(generateMemberId());
			
			entity.setTelephoneCountryCode(memberProfile.getPhoneNumberCountryCode());
			entity.setTelephoneNumber(memberProfile.getPhoneNumber());
			
			if (member.getMemberDetails() !=null && 
					!StringUtils.isEmpty(member.getMemberDetails().getProfilePictureUri())) {
				entity.setProfilePictureURI(member.getMemberDetails().getProfilePictureUri());
			}
			
			if (!StringUtils.isEmpty(memberProfile.getMiddleName())) {
				entity.setMiddleName(memberProfile.getMiddleName());
			}
			
			populateAddresses(member.getMemberDetails(), entity);
			
			populateOptionsInSelected(member.getMemberDetails() , entity) ;
			
			return entity;
		} catch(Exception e) {
			throw new ShackServiceException(ShackResourceConstants.ERROR_CODE_ADD_MEMBER,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MSG, e);
		}
	}
	

	/**
	 * 
	 * @param memberDetails
	 * @param entity
	 */
	private void populateAddresses(MemberDetailsDTO memberDetails, MemberMaster entity) {
		List<Address> addresses = new ArrayList<Address>();
		if (memberDetails != null && memberDetails.getMailAddress() != null) {
			addresses.add(createAddressEntity(memberDetails.getMailAddress(), AddressType.MAIL, entity));
		}
		if (memberDetails != null && memberDetails.getBillingAddress() != null) {
			addresses.add(createAddressEntity(memberDetails.getBillingAddress(), AddressType.BILL, entity));
		}

		if (!addresses.isEmpty()) {
			entity.setAddresses(addresses);
		}
	}
	
	/**
	 * 
	 * @param memberDetails
	 */
	private void populateOptionsInSelected(MemberDetailsDTO memberDetails , MemberMaster entity) { 
		List<OptIn> optIns = new ArrayList<OptIn>();
		
		if(memberDetails.getOptInSelected() !=null && !memberDetails.getOptInSelected().isEmpty()) {
			for (OptInDTO optionIn : memberDetails.getOptInSelected()) {
				optIns.add(createOptionInEntity(optionIn , entity ,  getOptionNumberVal(optionIn.getOptIn()))) ;
			}
		}
		
		if (!optIns.isEmpty()) {
			entity.setOptIns(optIns);
		}
	}		
		
	
	/**
	 * 
	 * @param addressInput
	 * @param addressType
	 * @return
	 */
	private Address createAddressEntity(MemberAddressDTO addressInput, AddressType addressType, MemberMaster entity) {
		Address address = new Address();
		address.setAddressLine1(addressInput.getAddressLine1());
		address.setAddressLine2(addressInput.getAddressLine2());
		address.setCityName(addressInput.getCity());
		address.setStateProv(addressInput.getState());
		address.setPostalCode(addressInput.getZipCode());
		address.setCountry(addressInput.getCountry());
		address.setAddressType(addressType);
		address.setCreateBy(RegistrationUtil.getLoggedInUserId());
		address.setUpdateBy(RegistrationUtil.getLoggedInUserId());
		address.setMemberMaster(entity);
		return address;
	}
	
	/**
	 * 
	 * @param optionIn
	 * @param entity
	 * @param optionValue
	 * @return
	 */
	private OptIn createOptionInEntity(OptInDTO optionIn, MemberMaster entity , int  optionValue) {
		OptIn optIn = new OptIn() ;
		optIn.setOptTypeID(new Long(optionValue));
		optIn.setStatus(MemberStatusEnum.A.toString());
		optIn.setCreateBy(RegistrationUtil.getLoggedInUserId());
		optIn.setUpdateBy(RegistrationUtil.getLoggedInUserId());
		optIn.setMemberMaster(entity);
		return optIn ;
	}
	
	/**
	 * 
	 * @return
	 */
	public Long generateMemberId() {
		int randomNum = Math.abs(ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
		return new Long(randomNum) ; 
	}
	
	/**
	 * 
	 * @param optionLabel
	 * @return
	 */
	private int getOptionNumberVal(String optionLabel) {
		for (OptionInType optionInType : OptionInType.values()) {
			if  (optionInType.getOptionLabel().equalsIgnoreCase(optionLabel)) {
				return optionInType.getOptionValue() ;
			}
		}
		/**
		 * Shouldn't get here a as the validation will catch and throw error
		 * before this level
		 */
		return 0 ;
	}
}
