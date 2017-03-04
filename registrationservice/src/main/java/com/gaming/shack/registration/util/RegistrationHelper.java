package com.gaming.shack.registration.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gaming.shack.core.utils.DateFormatterUtils;
import com.gaming.shack.data.entity.registration.Address;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.enums.AddressType;
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
	public MemberMaster createMemberMaster(MemberDTO member) {
		
		MemberProfileDTO memberProfile = member.getMemberProfile() ;
		
		MemberMaster entity = new MemberMaster();
		entity.setMemberID(memberProfile.getMemberId());
		entity.setNameTitle(memberProfile.getNameTitle());
		entity.setGivenName(memberProfile.getFirstName());
		entity.setSurname(memberProfile.getLastName());
		entity.setDateOfBirth(DateFormatterUtils.toDate(memberProfile.getDateOfBirth()));
		entity.setCreateBy("Shah");
		entity.setEmailaddress(memberProfile.getEmailId());
		entity.setUpdateBy("Shah");		
		entity.setParentMemberID(memberProfile.getParentMemberId());
		entity.setMembershipTypeID(new Long(memberProfile.getMembershipType()));
		entity.setMemberTypeID(new Long(memberProfile.getMemberType()));
		populateAddresses(member.getMemberDetails(), entity);
		return entity;
	}	
	
	/**
	 * 
	 * @param memberDetails
	 * @param entity
	 */
	private void populateAddresses(MemberDetailsDTO memberDetails , MemberMaster entity) {
		List<Address> addresses = new ArrayList<Address>() ;
		if (memberDetails !=null && memberDetails.getMailAddress() !=null) {
			addresses.add(createAddressEntity( memberDetails.getMailAddress(), AddressType.MAIlING_ADDRESS)) ;
		} 
		if (memberDetails !=null && memberDetails.getBillingAddress() !=null) {
			addresses.add(createAddressEntity( memberDetails.getBillingAddress(), AddressType.BILLING_ADDRESS)) ;
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
	private Address createAddressEntity(MemberAddressDTO addressInput , AddressType addressType) {
		Address address = new Address() ;
		address.setAddressLine1(addressInput.getAddressLine1());
		address.setAddressLine2(addressInput.getAddressLine2());
		address.setCityName(addressInput.getCity());
		address.setStateProv(addressInput.getState());
		address.setPostalCode(addressInput.getZipCode());
		address.setCountry(addressInput.getCountry());
		address.setAddressType(addressType);
		return address ;
	}
}
