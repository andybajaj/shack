package com.gaming.shack.registration.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gaming.shack.core.constants.ShackResourceConstants;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.entity.registration.Channel;
import com.gaming.shack.data.entity.registration.SiteMaster;
import com.gaming.shack.data.enums.ChannelType;
import com.gaming.shack.data.enums.MemberType;
import com.gaming.shack.data.enums.MembershipType;
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
public class RegistrationValidationHelper {

	/**
	 * 
	 * @param memberProfile
	 * @throws ShackValidationException
	 */
	public void validateMemberProfile(MemberDTO member) throws ShackValidationException {

		MemberProfileDTO memberProfile = member.getMemberProfile();

		String validationErrorCode = ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION;

		if (memberProfile.getMemberId() == null || memberProfile.getMemberId() <= 0) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MEMBER_ID);
		}

		if (StringUtils.isEmpty(memberProfile.getFirstName())) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_FIRST_NAME);
		}

		if (StringUtils.isEmpty(memberProfile.getLastName())) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_FIRST_NAME);
		}

		if (StringUtils.isEmpty(memberProfile.getEmailId())) {
			throw new ShackValidationException(validationErrorCode, ShackResourceConstants.ERROR_CODE_ADD_MEMBER_EMAIL);
		}

		if (StringUtils.isEmpty(memberProfile.getDateOfBirth())) {
			throw new ShackValidationException(validationErrorCode, ShackResourceConstants.ERROR_CODE_ADD_MEMBER_DOB);
		}

		if (memberProfile.getPreferredSite() == null || memberProfile.getPreferredSite() <= 0) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_PREF_SITE);
		}

		if (memberProfile.getChannelId() == null || memberProfile.getChannelId() <= 0) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_CHANNEL);
		}
		
		validateChannel(memberProfile.getChannelId());
		
		validateMembership(memberProfile);		
		validateMemberAddress(member.getMemberDetails());
	}
	
	/**
	 * 
	 * @param channelId
	 * @throws ShackValidationException
	 */
	private void validateChannel(Long channelId) throws ShackValidationException {
		for (ChannelType channelType : ChannelType.values()) {
			if (channelType.getChanneId() == channelId.intValue()) {
				return ;
			}
		}
		throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
				ShackResourceConstants.ERROR_CODE_ADD_CHANNEL_NDF_SYS); 
	}


	/**
	 * 
	 * @param siteMaster
	 * @param channel
	 * @throws ShackValidationException
	 */
	public void validateSiteAndChannel(SiteMaster siteMaster, Channel channel) throws ShackValidationException {
		if (siteMaster == null) {
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_PREF_SITE);
		}

		if (channel == null) {
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_CHANNEL);
		}
	}

	/**
	 * 
	 * @param memberProfile
	 * @throws ShackValidationException
	 */
	private void validateMembership(MemberProfileDTO memberProfile) throws ShackValidationException {
		if (memberProfile.getMembershipType() <= 0) {
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MEMBERSHIPTYPE);
		}

		if (memberProfile.getMemberType() <= 0) {
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MEMBERTYPE);
		}

		MembershipType selectedMemshipType = getMembershipType(memberProfile.getMembershipType());
		if (selectedMemshipType == null) {
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MEMBERSHIPTYPE_NOT_DEFINED);
		}

		MemberType selectedMemType = getMemberType(memberProfile.getMemberType());
		if (selectedMemType == null) {
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MEMBERTYPE_NOT_DEFINED);
		}
	}

	/**
	 * 
	 * @param memberDetails
	 * @throws ShackValidationException
	 */
	private void validateMemberAddress(MemberDetailsDTO memberDetails) throws ShackValidationException {
		if (memberDetails != null && memberDetails.getMailAddress() != null) {
			validateAddressAttibutes(memberDetails.getMailAddress());
		}
		if (memberDetails != null && memberDetails.getBillingAddress() != null) {
			validateAddressAttibutes(memberDetails.getBillingAddress());
		}
	}

	/**
	 * 
	 * @param mailAddress
	 */
	private void validateAddressAttibutes(MemberAddressDTO mailAddress) throws ShackValidationException {
		String validationErrorCode = ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION;

		if (StringUtils.isEmpty(mailAddress.getAddressLine1())) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_ADDRESSLINE1);
		}
		if (StringUtils.isEmpty(mailAddress.getCity())) {
			throw new ShackValidationException(validationErrorCode, ShackResourceConstants.ERROR_CODE_ADD_MEMBER_CITY);
		}
		if (StringUtils.isEmpty(mailAddress.getState())) {
			throw new ShackValidationException(validationErrorCode, ShackResourceConstants.ERROR_CODE_ADD_MEMBER_STATE);
		}
		if (StringUtils.isEmpty(mailAddress.getZipCode())) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_ZIPCODE);
		}
		if (StringUtils.isEmpty(mailAddress.getCountry())) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_COUNTRY);
		}
	}

	/**
	 * 
	 * @param typeValue
	 * @return
	 */
	public MembershipType getMembershipType(int typeValue) {
		for (MembershipType membershipType : MembershipType.values()) {
			if (membershipType.getValue() == typeValue) {
				return membershipType;
			}
		}

		return null;
	}

	/**
	 * 
	 * @param typeValue
	 * @return
	 */
	public MemberType getMemberType(int typeValue) {
		for (MemberType memberType : MemberType.values()) {
			if (memberType.getValue() == typeValue) {
				return memberType;
			}
		}
		return null;
	}
}
