package com.gaming.shack.authentication.service;

import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.model.LoginDTO;
import com.gaming.shack.data.model.LoginResponse;

public interface IAuthenticationService {
	public LoginResponse login(LoginDTO logindt) throws ShackServiceException,ShackValidationException;

}
