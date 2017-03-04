package com.gaming.shack.registration.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import com.gaming.shack.core.constants.ShackResourceConstants;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.utils.DateFormatterUtils;
import com.gaming.shack.data.entity.registration.Address;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.enums.AddressType;
import com.gaming.shack.data.enums.MemberStatusEnum;
import com.gaming.shack.data.model.MemberAddressDTO;
import com.gaming.shack.data.model.MemberDTO;
import com.gaming.shack.data.model.MemberDetailsDTO;
import com.gaming.shack.data.model.MemberProfileDTO;

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
			entity.setProfilePictureURI(memberProfile.getProfilePictureUri());
			populateAddresses(member.getMemberDetails(), entity);
			
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
	 * @return
	 */
	public Long generateMemberId() {
		int randomNum = Math.abs(ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE));
		return new Long(randomNum) ; 
	}
}
