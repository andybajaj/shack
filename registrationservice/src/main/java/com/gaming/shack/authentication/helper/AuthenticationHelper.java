package com.gaming.shack.authentication.helper;


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import com.gaming.shack.core.constants.ShackConstant;
import com.gaming.shack.core.exception.ShackValidationException;
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
	
	
	public static MemberActivation constructMemberActivationEntity(MemberMaster member , String trackingID) throws ShackValidationException {
		
		MemberActivation memberActivation = new MemberActivation();
		memberActivation.setMemberMaster(member);
		memberActivation.setActivationType(ShackConstant.ACTIVATION_TYPE_FORG_PSWD);
		memberActivation.setUniqueID(trackingID);
		memberActivation.setCreateDate(getCurrentDate());
		memberActivation.setCreateBy(ShackConstant.CREATED_BY);
		memberActivation.setValidityMinute(ShackConstant.VALIDITY_MINUTE);
		memberActivation.setExpiryTime(calculateExpireTime());
		memberActivation.setActivationTime(null);
		memberActivation.setCreationTime(new Date());
		memberActivation.setUpdateBy(ShackConstant.CREATED_BY);

		memberActivation.setUpdateDate(getCurrentDate());

		return memberActivation;
		
	}
	
	public static Timestamp getCurrentDate(){
		
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();

		// 2) get a java.util.Date from the calendar instance.
//		    this date will represent the current instant, or "now".
		java.util.Date now = calendar.getTime();

		// 3) a java current time (now) instance
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		
		
		return currentTimestamp;
		
	}
	
	
public static Timestamp calculateExpireTime(){
		
		// 1) create a java calendar instance
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.MINUTE, 30);

		// 2) get a java.util.Date from the calendar instance.
//		    this date will represent the current instant, or "now".
		java.util.Date expiryDate = calendar.getTime();

		// 3) a java current time (now) instance
		java.sql.Timestamp expTimestamp = new java.sql.Timestamp(expiryDate.getTime());
		
		
		return expTimestamp;
		
	}

}
