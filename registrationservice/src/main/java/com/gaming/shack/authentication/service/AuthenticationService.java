package com.gaming.shack.authentication.service;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaming.shack.authentication.dao.IAuthenticationDao;
import com.gaming.shack.authentication.helper.AuthenticationHelper;
import com.gaming.shack.core.annotation.ShackRTX;
import com.gaming.shack.core.constants.ShackConstant;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.entity.registration.MemberAccount;
import com.gaming.shack.data.entity.registration.MemberActivation;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.enums.MemberStatusEnum;
import com.gaming.shack.data.model.LoginBaseDTO;
import com.gaming.shack.data.model.LoginDTO;
import com.gaming.shack.data.model.LoginResponse;
import com.gaming.shack.data.model.PasswordResetRequestDTO;
import com.gaming.shack.data.model.PasswordResetResponse;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private IAuthenticationDao<Serializable, Serializable> authDAO;

	@ShackRTX
	@Override
	public LoginResponse login(LoginDTO logindt) throws ShackServiceException, ShackValidationException {

		LoginResponse response = null;
		try {

			MemberMaster member = null;
			MemberAccount memberAcc = null;

			// 1. check if the input ID is valid.
			String loginorEmailID = logindt.getId();
			boolean isId = StringUtils.isNumeric(loginorEmailID);

			if (isId) {
				Long id = new Long(loginorEmailID);
				member = authDAO.findMemberById(id);

			} else {
				member = authDAO.findMemberByEmailID(loginorEmailID);
			}

			if (member == null) {
				throw new ShackValidationException("100", "given member id or email not found");
			}

			// 2. check member status and throw error
			MemberStatusEnum memberStatus = member.getMemberStatus();
			AuthenticationHelper.validateLoginMemberStatus(memberStatus);

			// Storing memberId for further processing
			Long mmID = member.getMmid();

			// 3. read member account detail
			// memberAcc = authDAO.findMemberAccount(memberId);
			memberAcc = member.getMemberAccount();

			// throw error if member account not exist
			if (memberAcc == null) {
				throw new ShackValidationException("106", "Member Account detail doesn't exist");

			}
			// 4. validate the input password against the DB
			// throw error if not matching.
			if (!StringUtils.isEmpty(memberAcc.getPassword())) {

				if (!(logindt.getPasscode().equals(memberAcc.getPassword()))) {

					// Increment the error attempt count and other attributes if
					// failed.
					// update the member status to lock after 3 attempt

					// update no of failed count
					authDAO.updateNoOfFailedAttempt(memberAcc.getNoOfFailAttem() + 1, mmID);

					// set status as locked
					if (memberAcc.getNoOfFailAttem() >= (ShackConstant.MAX_LOGGIN_ATTEMPT - 1)) {
						authDAO.updateMemberStatus(MemberStatusEnum.L, mmID);
					}

					throw new ShackValidationException("109", "password doesnt match");
				}
			}

			// if success - update error attempt count to zero and update last
			// successful login time.
			authDAO.updateSucessLogin(mmID);

			response = new LoginResponse();
			response.setSessionID(UUID.randomUUID().toString());

		} catch (ShackDAOException e) {
			throw new ShackServiceException("AUTH_SERV_ERR", "exception in Login service");
		}

		return response;

	}

	@ShackRTX
	@Override
	public void forgotPassword(LoginBaseDTO logindt) throws ShackServiceException, ShackValidationException {

		try {

			MemberMaster member = null;

			// 1. check if the input ID is valid.
			String loginorEmailID = logindt.getId();
			boolean isId = StringUtils.isNumeric(loginorEmailID);

			if (isId) {
				Long id = new Long(loginorEmailID);
				member = authDAO.findMemberById(id);

			} else {
				member = authDAO.findMemberByEmailID(loginorEmailID);
			}

			if (member == null) {
				throw new ShackValidationException("100", "given member id or email not found");
			}

			// 2. check member status and throw error
			MemberStatusEnum memberStatus = member.getMemberStatus();
			AuthenticationHelper.validateForgotPwdMemberStatus(memberStatus);

			// 3. add new record in member activity table with unique key.
			String trackingID = UUID.randomUUID().toString();
			MemberActivation memberActivtion = AuthenticationHelper.constructMemberActivationEntity(member, trackingID);
			authDAO.add(memberActivtion);

			// 4. send notification

		} catch (ShackDAOException e) {
			throw new ShackServiceException("AUTH_SERV_ERR", "exception in forgotPassword service");
		}
	}

	
	@ShackRTX
	@Override
	public PasswordResetResponse resetPasswordPreCheck(String trackingID)
			throws ShackServiceException, ShackValidationException {

		PasswordResetResponse  response = null;
		try {

			// 1. check if activation ID exist
			MemberActivation memberActivation = authDAO.findMemberActivByUniqueId(trackingID);

			if (memberActivation == null) {
				throw new ShackValidationException("120", "given activation id not found");
			}

			// 2. check for valid member
			MemberMaster memMaster = memberActivation.getMemberMaster();

			if (memMaster == null) {
				throw new ShackValidationException("121", "For the given activation id ,member id not found");
			}

			// 3. validate member status
			MemberStatusEnum memberStatus = memMaster.getMemberStatus();
			AuthenticationHelper.validateForgotPwdMemberStatus(memberStatus);

			// 4. check if the given tracking id was used already
			if(memberActivation.getActivationTime() !=null){
				throw new ShackValidationException("122", "This activatin link has been used already");
			}
			
			// 5. Validate the activation request expiration time
			Date expTime = memberActivation.getExpiryTime();

			if (expTime.before(new Date(System.currentTimeMillis()))) {
				throw new ShackValidationException("123", "Activation id is expired");
			}

			// 5. build response
			
			response = new PasswordResetResponse();
			response.setMemberId(memMaster.getMemberID());
			response.setEmailId(memMaster.getEmailaddress());
			

		} catch (ShackDAOException e) {
			throw new ShackServiceException("AUTH_SERV_ERR", "exception in resetPasswordPreCheck");
		}

		return response;
	}

	@ShackRTX
	@Override
	public void resetPassword(PasswordResetRequestDTO resetRequestDTO)
			throws ShackServiceException, ShackValidationException {

		try {

			// 1. check if activation ID exist
			MemberActivation memberActivation = authDAO.findMemberActivByUniqueId(resetRequestDTO.getTrackingID());

			if (memberActivation == null) {
				throw new ShackValidationException("120", "given activation id not found");
			}

			// 2. check for valid member
			MemberMaster memMaster = memberActivation.getMemberMaster();

			if (memMaster == null) {
				throw new ShackValidationException("121", "For the given activation id ,member id not found");
			}

			// 3. validate member status
			MemberStatusEnum memberStatus = memMaster.getMemberStatus();
			AuthenticationHelper.validateForgotPwdMemberStatus(memberStatus);

			// 4. check if the given tracking id was used already
			if(memberActivation.getActivationTime() !=null){
				throw new ShackValidationException("122", "This activatin link has been used already");
			}
			
			// 5. Validate the activation request expiration time
			Date expTime = memberActivation.getExpiryTime();

			if (expTime.before(new Date(System.currentTimeMillis()))) {
				throw new ShackValidationException("123", "Activation id is expired");
			}

			//6.update memberAccount, memberMaster and member activity tables.
			
			// set new values
			AuthenticationHelper.populateMemberMasterForPasswordReset(memMaster);
			MemberAccount memAccount =  memMaster.getMemberAccount();
			AuthenticationHelper.poulateMemberAccountForPasswordReset(memAccount, resetRequestDTO.getPasscode());
			AuthenticationHelper.poulateMemberActivationForPasswordReset(memberActivation);
			
			//update activating time to current time
			authDAO.update(memberActivation);
			//update new password, last password reset time and noOfFailAttempt=0
			authDAO.update(memAccount);
			//update status to ACTIVE if prior status is locked
			authDAO.update(memMaster);
			

		} catch (ShackDAOException e) {
			throw new ShackServiceException("AUTH_SERV_ERR", "exception in resetPasswordPreCheck");
		}

		
	}
}