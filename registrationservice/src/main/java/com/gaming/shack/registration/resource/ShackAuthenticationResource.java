package com.gaming.shack.registration.resource;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaming.shack.authentication.service.IAuthenticationService;
import com.gaming.shack.core.exception.ShackResourceException;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.data.model.LoginDTO;
import com.gaming.shack.data.model.LoginResponse;


@Service("ShackAuthenticationResource")
public class ShackAuthenticationResource implements IShackAuthenticationResource{
	
	private static final Logger LOGGER = LogManager.getLogger(ShackAuthenticationResource.class);
	
	@Autowired
	private IAuthenticationService authenticationService;

	@Override
	public LoginResponse login(LoginDTO loginDTO) throws ShackResourceException {
		
		System.out.println("loginDTO "+loginDTO);
		
		try{
		
			LoginResponse resp = authenticationService.login(loginDTO);
			
		}catch (ShackServiceException e) {
			throw new ShackResourceException("111", "Error in login");
		}
		
		LoginResponse response = new LoginResponse();
		response.setSessionID(UUID.randomUUID().toString());
		
		return response;
	}

}
