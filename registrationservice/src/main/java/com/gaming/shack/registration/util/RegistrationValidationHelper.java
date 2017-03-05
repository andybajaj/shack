package com.gaming.shack.registration.util;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.gaming.shack.core.constants.ShackResourceConstants;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.core.utils.DateFormatterUtils;
import com.gaming.shack.data.entity.registration.Channel;
import com.gaming.shack.data.entity.registration.SiteMaster;
import com.gaming.shack.data.enums.ChannelType;
import com.gaming.shack.data.enums.MemberType;
import com.gaming.shack.data.enums.MembershipType;
import com.gaming.shack.data.enums.OptionInType;
import com.gaming.shack.data.model.MemberAddressDTO;
import com.gaming.shack.data.model.MemberDTO;
import com.gaming.shack.data.model.MemberDetailsDTO;
import com.gaming.shack.data.model.MemberProfileDTO;
import com.gaming.shack.data.model.OptInDTO;
import com.gaming.shack.registration.constants.RegistrationConstants;

/**
 * The helper class for the registration
 * 
 * @author shahnawf
 *
 */
@Component
public class RegistrationValidationHelper {

	private static final Logger LOGGER = LogManager.getLogger(RegistrationValidationHelper.class);

	/**
	 * 
	 * @param memberProfile
	 * @throws ShackValidationException
	 */
	public void validateMemberProfile(MemberDTO member) throws ShackValidationException {

		MemberProfileDTO memberProfile = member.getMemberProfile();

		String validationErrorCode = ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION;

		if (StringUtils.isEmpty(memberProfile.getFirstName())) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_FIRST_NAME);
		}

		if (StringUtils.isEmpty(memberProfile.getLastName())) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_FIRST_NAME);
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

		if (memberProfile.getTcTemplateId() == null || memberProfile.getTcTemplateId() <= 0) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_CHANNEL);
		}

		if (memberProfile.getCardBarCode() == null || memberProfile.getCardBarCode() <= 0) {
			throw new ShackValidationException(validationErrorCode, ShackResourceConstants.ERROR_CODE_ADD_CARDBARCODE);
		}

		validateEmailAndChannel(memberProfile);

		validateMembership(memberProfile);
		validateMemberAddress(member.getMemberDetails());
		
		validateSelectedOptions(member.getMemberDetails()) ;

	}
	
	/**
	 * 
	 * @param channelId
	 * @throws ShackValidationException
	 */
	private void validateEmailAndChannel(MemberProfileDTO memberProfile) throws ShackValidationException {

		ChannelType selectedChannelType = null;
		for (ChannelType channelType : ChannelType.values()) {
			if (channelType.getChanneId() == memberProfile.getChannelId()) {
				selectedChannelType = channelType;
				break;
			}
		}

		if (selectedChannelType == null) {
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_CHANNEL_NDF_SYS);
		}

		if ((selectedChannelType == ChannelType.WEBSITE || selectedChannelType == ChannelType.MOBILEAPP)
				&& StringUtils.isEmpty(memberProfile.getEmailId())) {

			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_EMAIL);
		}

		if (StringUtils.isEmpty(memberProfile.getEmailId())) {
			memberProfile.setEmailId(null);
		}
	}
	
	/**
	 * 
	 * @param memberDetails
	 */
	private void validateSelectedOptions(MemberDetailsDTO memberDetails) throws ShackValidationException {
		if (memberDetails != null && memberDetails.getOptInSelected() != null
				&& !memberDetails.getOptInSelected().isEmpty()) {
			
			for (OptInDTO option : memberDetails.getOptInSelected()) {
				if (!isOptionInTypeExists(option.getOptIn())) {
					throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
							ShackResourceConstants.ERROR_CODE_ADD_PARENT_OPTIONTYPE_IN);
				}
			}
		}

	}
	
	/**
	 * 
	 * @param optionLabel
	 * @return
	 */
	private boolean isOptionInTypeExists(String optionLabel) {
		for (OptionInType optionInType : OptionInType.values()) {
			if  (optionInType.getOptionLabel().equalsIgnoreCase(optionLabel)) {
				return true ;
			}
		}
		
		return false ;
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

		
		MemberType selectedMemType = getMemberType(memberProfile.getMemberType());
		if (selectedMemType == null) {
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MEMBERTYPE_NOT_DEFINED);
		}

		Date dateOfBirth;
		try {
			dateOfBirth = DateFormatterUtils.toDate(memberProfile.getDateOfBirth());
		} catch (Exception e) {
			LOGGER.error("Error while date conversion", e);
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_DOB);
		}
		
		long memberAge = DateFormatterUtils.getDateDiffInYears(dateOfBirth) ;
				
		if (RegistrationConstants.AGE_TILL_MINOR >= memberAge && (MemberType.ADULT == selectedMemType ||
				MemberType.SR_CITIZE == selectedMemType)) {
			
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_INVALID_MEMTYPE_FOR_MINOR);
		}
		
		if (RegistrationConstants.AGE_TILL_MINOR < memberAge && MemberType.MINOR == selectedMemType) {
			
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_INVALID_MEMTYPE_FOR_NONMINOR);
		}
		
		if(MemberType.MINOR == selectedMemType && (memberProfile.getParentMemberId() == null || 
				memberProfile.getParentMemberId() <=0)) {
			
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_PARENT_MEMBERID);
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
