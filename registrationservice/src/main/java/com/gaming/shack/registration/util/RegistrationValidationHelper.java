package com.gaming.shack.registration.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gaming.shack.core.constants.ShackResourceConstants;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.entity.registration.Channel;
import com.gaming.shack.data.entity.registration.SiteMaster;
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
	public void validateMemberProfile(MemberProfileDTO memberProfile) throws ShackValidationException {

		String validationErrorCode = ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION;

		if (memberProfile.getMemberId() == null || memberProfile.getMemberId() <=0) {
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

		if (memberProfile.getPreferredSite() == null || memberProfile.getPreferredSite() <=0) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_PREF_SITE);
		}

		if (memberProfile.getChannelId() == null || memberProfile.getChannelId() <=0) {
			throw new ShackValidationException(validationErrorCode,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_CHANNEL);
		}
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
}