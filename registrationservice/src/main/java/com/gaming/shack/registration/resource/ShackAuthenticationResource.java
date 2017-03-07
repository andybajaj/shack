package com.gaming.shack.registration.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaming.shack.authentication.service.IAuthenticationService;
import com.gaming.shack.core.exception.ShackResourceException;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.data.model.LoginBaseDTO;
import com.gaming.shack.data.model.LoginDTO;
import com.gaming.shack.data.model.LoginResponse;
import com.gaming.shack.data.model.PasswordResetRequestDTO;
import com.gaming.shack.data.model.PasswordResetResponse;


@Service("ShackAuthenticationResource")
public class ShackAuthenticationResource implements IShackAuthenticationResource{
	
	
	@Autowired
	private IAuthenticationService authenticationService;

	@Override
	public LoginResponse login(LoginDTO loginDTO) throws ShackResourceException {
		
		LoginResponse resp =null;
		
		try{
		
			resp = authenticationService.login(loginDTO);
			
		}catch (ShackServiceException e) {
			throw new ShackResourceException("111", "Error in login");
		}
	
		return resp;
	}
	
	@Override
	public List<String> forGotPassword(LoginBaseDTO loginBaseDTO) throws ShackResourceException {
		
		try{
		
			authenticationService.forgotPassword(loginBaseDTO);
			
		}catch (ShackServiceException e) {
			throw new ShackResourceException("112", "Error in ForgotPassword");
		}
		
		return Collections.emptyList();
	}
	
	
	@Override
	public PasswordResetResponse resetPasswordPreCheck(String trackingID) throws ShackResourceException {
		
		PasswordResetResponse response = null;

		try{
			
			response = authenticationService.resetPasswordPreCheck(trackingID);
			
		}catch (ShackServiceException e) {
			throw new ShackResourceException("113", "Error in resetPasswordPreCheck");
		}
		
		return response;
		
	}
	@Override
	public List<String> resetPassword(PasswordResetRequestDTO resetRequestDTO) throws ShackResourceException {

		try{
			
			authenticationService.resetPassword(resetRequestDTO);
			
		}catch (ShackServiceException e) {
			throw new ShackResourceException("114", "Error in resetPassword");
		}
		
		return Collections.emptyList();
		
	}
	
	@Override
	public List<String> notifyMemberActivation(LoginBaseDTO loginBaseDTO) throws ShackResourceException {
		
		try{
		
			authenticationService.notifyMemberActivation(loginBaseDTO);
			
		}catch (ShackServiceException e) {
			throw new ShackResourceException("115", "Error in notifyMemberActivation");
		}
		
		return Collections.emptyList();
	}
	
	@Override
	public List<String> activateMemberProfile(String trackingID) throws ShackResourceException{
		
		try{
			
			authenticationService.activateMemberProfile(trackingID);
			
		}catch (ShackServiceException e) {
			throw new ShackResourceException("116", "Error in activateMemberProfile");
		}
		
		return Collections.emptyList();
	}

}
