package com.gaming.shack.authentication.helper;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import com.gaming.shack.core.constants.ShackConstant;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.entity.registration.MemberAccount;
import com.gaming.shack.data.entity.registration.MemberActivation;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.enums.MemberStatusEnum;

public class AuthenticationHelper {

	public static void validateLoginMemberStatus(MemberStatusEnum memberStatus) throws ShackValidationException {

		if (memberStatus == null) {
			throw new ShackValidationException("101", "No valid member status found");
		}

		switch (memberStatus) {
		case P:
			throw new ShackValidationException("102", "Member not registererd the online account");
		case N:
			throw new ShackValidationException("103", "Member account is in new status");
		case NC:
			throw new ShackValidationException("104", "Member account is not acive yet");
		case L:
			throw new ShackValidationException("104", "Member account is locked");
		case S:
			throw new ShackValidationException("105", "Member account is suspended");
		default:

		}

	}

	public static void validateForgotPwdMemberStatus(MemberStatusEnum memberStatus) throws ShackValidationException {

		if (memberStatus == null) {
			throw new ShackValidationException("101", "No valid member status found");
		}

		switch (memberStatus) {
		case P:
			throw new ShackValidationException("102", "Member not registererd the online account");

		case NC:
			throw new ShackValidationException("104", "Member account is not acive yet");

		case S:
			throw new ShackValidationException("105", "Member account is suspended");
		default:

		}

	}

	public static void validateActivationLinkMemberStatus(MemberStatusEnum memberStatus) throws ShackValidationException {

		if (memberStatus == null) {
			throw new ShackValidationException("101", "No valid member status found");
		}

		switch (memberStatus) {
		case P:
			throw new ShackValidationException("102", "Member not registererd the online account");
		case N:
			throw new ShackValidationException("103", "Member account is in new status");
		
		case L:
			throw new ShackValidationException("104", "Member account is locked");
		case S:
			throw new ShackValidationException("105", "Member account is suspended");
		case NC:
			break;
		default:

		}

		}

	

	public static MemberActivation constructMemberActivationEntity(MemberMaster member, String trackingID,boolean isForgotPswd)
			throws ShackValidationException {

		MemberActivation memberActivation = new MemberActivation();
		memberActivation.setMemberMaster(member);
		memberActivation.setUniqueID(trackingID);
		memberActivation.setCreateDate(getCurrentDate());
		memberActivation.setCreateBy(ShackConstant.CREATED_BY);
	
		if(isForgotPswd)
		{
			memberActivation.setExpiryTime(calculateExpireTime(ShackConstant.FORGOTPWD_VALIDITY_MINUTE));
			memberActivation.setActivationType(ShackConstant.ACTIVATION_TYPE.ForgotPWD.toString());
			memberActivation.setValidityMinute(new Long(ShackConstant.FORGOTPWD_VALIDITY_MINUTE));
		}else{
			memberActivation.setExpiryTime(calculateExpireTime(ShackConstant.ACTIVATION_VALIDITY_MINUTE));
			memberActivation.setActivationType(ShackConstant.ACTIVATION_TYPE.Activation.toString());
			memberActivation.setValidityMinute(new Long(ShackConstant.ACTIVATION_VALIDITY_MINUTE));
		}
		
		memberActivation.setActivationTime(null);
		memberActivation.setCreationTime(new Date());
		memberActivation.setUpdateBy(ShackConstant.CREATED_BY);
		memberActivation.setUpdateDate(getCurrentDate());

		return memberActivation;

	}

	public static  void populateMemberMasterForPasswordReset(MemberMaster memMaster)
			throws ShackValidationException {

		if (memMaster.getMemberStatus() == MemberStatusEnum.L) {
			memMaster.setUpdateBy(ShackConstant.CREATED_BY);
			memMaster.setUpdateDate(AuthenticationHelper.getCurrentDate());
			memMaster.setMemberStatus(MemberStatusEnum.A);

		}

	}

	public static void poulateMemberAccountForPasswordReset(MemberAccount memAccount, String newPassCode)
			throws ShackValidationException {

		memAccount.setPassword(newPassCode);
		memAccount.setLastUpdateDate(getCurrentDate());
		memAccount.setNoOfFailAttem(0L);
		memAccount.setLastPasswordReset(AuthenticationHelper.getCurrentDate().toString());//TBD change to date

	}

	public static void poulateMemberActivationForPasswordResetOrActivation(MemberActivation memActivation)
			throws ShackValidationException {

		memActivation.setActivationTime(new Date(System.currentTimeMillis()));
		memActivation.setUpdateBy(ShackConstant.CREATED_BY);
		memActivation.setUpdateDate(getCurrentDate());

	}

	public static Timestamp getCurrentDate() {

		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();

		// 2) get a java.util.Date from the calendar instance.
		// this date will represent the current instant, or "now".
		java.util.Date now = calendar.getTime();

		// 3) a java current time (now) instance
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());

		return currentTimestamp;

	}

	public static Timestamp calculateExpireTime(int expMinute) {

		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.MINUTE, expMinute);

		// 2) get a java.util.Date from the calendar instance.
		// this date will represent the current instant, or "now".
		java.util.Date expiryDate = calendar.getTime();

		// 3) a java current time (now) instance
		java.sql.Timestamp expTimestamp = new java.sql.Timestamp(expiryDate.getTime());

		return expTimestamp;

	}

}
