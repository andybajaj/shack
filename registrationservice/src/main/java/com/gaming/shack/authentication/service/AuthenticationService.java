package com.gaming.shack.authentication.service;

import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaming.shack.authentication.dao.IAuthenticationDao;
import com.gaming.shack.core.annotation.ShackRTX;
import com.gaming.shack.core.constants.ShackConstant;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.entity.registration.MemberAccount;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.enums.MemberStatusEnum;
import com.gaming.shack.data.model.LoginDTO;
import com.gaming.shack.data.model.LoginResponse;

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
				System.out.println("----------login id found--------");

			} else {
				member = authDAO.findMemberByEmailID(loginorEmailID);
				System.out.println("----------email id found--------");
			}

			if (member == null) {
				System.out.println("----------email or  id not found error condition--------");
				throw new ShackValidationException("100", "given member id or email not found");
			}

			// 2. check member status and throw error
			String memberStatus = member.getMemberStatus();
			validateMemberStatus(memberStatus);

			// Storing memberId for further processing
			Long memberId = member.getMemberID();

			// 3. read member account detail
			memberAcc = authDAO.findMemberAccount(memberId);
			// throw error if member account not exist
			if (memberAcc == null) {
				System.out.println("----------member account not found error condition--------");
				throw new ShackValidationException("106", "Member Account detail doesn't exist");

			}
			// 4. validate the input password against the DB
			// throw error if not matching.
			if (!StringUtils.isEmpty(memberAcc.getPassword())) {

				if (!(logindt.getPasscode().equals(memberAcc.getPassword()))) {

					System.out.println("----------Password doesnt match--------");

					// Increment the error attempt count and other attributes if
					// failed.
					// update the member status to lock after 3 attempt

					// update no of failed count
					authDAO.updateNoOfFailedAttempt(memberAcc.getNoOfFailAttem() + 1, memberId);

					// set status as locked
					if (memberAcc.getNoOfFailAttem() == (ShackConstant.MAX_LOGGIN_ATTEMPT - 1)) {
						authDAO.updateMemberStatus(MemberStatusEnum.LOCKED.valueOf(), memberId);
					}

					throw new ShackValidationException("109", "password doesnt match");
				}
			}

			// if success - update error attempt count to zero and update last successful login time.
			authDAO.updateSucessLogin(memberId);

			response = new LoginResponse();
			response.setSessionID(UUID.randomUUID().toString());

		} catch (ShackDAOException e) {
			throw new ShackServiceException("AUTH_SERV_ERR", "exception in Login service");
		}

		return response;

	}

	private void validateMemberStatus(String memberStatus) throws ShackValidationException {


		if (StringUtils.isEmpty(memberStatus)) {
			throw new ShackValidationException("101", "No valid member status found");
		}

		switch (MemberStatusEnum.toEnum(memberStatus)) {
		case PRE:
			throw new ShackValidationException("102", "Member not registererd the online account");
		case NEW:
			throw new ShackValidationException("103", "Member account is in new status");
		case NOTACTIVE:
			throw new ShackValidationException("104", "Member account is not acive yet");
		case LOCKED:
			throw new ShackValidationException("104", "Member account is locked");
		case SUSPENDED:
			throw new ShackValidationException("105", "Member account is suspended");
		default:

		}
		
	}

}