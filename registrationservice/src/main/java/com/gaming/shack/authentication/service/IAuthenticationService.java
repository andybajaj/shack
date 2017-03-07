package com.gaming.shack.authentication.service;



import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.model.LoginBaseDTO;
import com.gaming.shack.data.model.LoginDTO;
import com.gaming.shack.data.model.LoginResponse;
import com.gaming.shack.data.model.PasswordResetRequestDTO;
import com.gaming.shack.data.model.PasswordResetResponse;

public interface IAuthenticationService {
	public LoginResponse login(LoginDTO logindt) throws ShackServiceException,ShackValidationException;
	public void forgotPassword(LoginBaseDTO logindt) throws ShackServiceException, ShackValidationException;
	public PasswordResetResponse resetPasswordPreCheck(String activId) throws ShackServiceException, ShackValidationException;
	public void resetPassword(PasswordResetRequestDTO loginDTO)throws ShackServiceException, ShackValidationException;
	public void notifyMemberActivation(LoginBaseDTO logindt) throws ShackServiceException, ShackValidationException;
	public void activateMemberProfile(String trackingID) throws ShackServiceException, ShackValidationException ;
}
