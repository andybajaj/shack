package com.gaming.shack.registration.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gaming.shack.core.exception.ShackResourceException;
import com.gaming.shack.data.model.LoginBaseDTO;
import com.gaming.shack.data.model.LoginDTO;
import com.gaming.shack.data.model.LoginResponse;
import com.gaming.shack.data.model.PasswordResetRequestDTO;
import com.gaming.shack.data.model.PasswordResetResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/registration")
@Api(value = "/registration", tags = "registration")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IShackAuthenticationResource {

	@POST
	@Path("/login")
	@ApiOperation(value = "Shack API to log-in", notes = "This is a shack Endpoint to log-in")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response from API"),
			@ApiResponse(code = 400, message = "Input fields validation error?"),
			@ApiResponse(code = 412, message = "business fields validation error?"),
			@ApiResponse(code = 500, message = "application system error?")})
	public LoginResponse login(LoginDTO loginDTO) throws ShackResourceException;
	
	@POST
	@Path("/forgotpassword")
	@ApiOperation(value = "Shack API to for  forgotpassword", notes = "This is a shack Endpoint to forgotPassword")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response from API"),
			@ApiResponse(code = 400, message = "Input fields validation error?"),
			@ApiResponse(code = 412, message = "business fields validation error?"),
			@ApiResponse(code = 500, message = "application system error?")})
	public List<String> forGotPassword(LoginBaseDTO loginBaseDTO) throws ShackResourceException ;
	

	@PUT
	@Path("/resetpasswordprecheck/{trackingid}")
	@ApiOperation(value = "Shack API to for  resetPasswordprecheck", notes = "This is a shack Endpoint to resetpassword precheck")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response from API"),
			@ApiResponse(code = 400, message = "Input fields validation error?"),
			@ApiResponse(code = 412, message = "business fields validation error?"),
			@ApiResponse(code = 500, message = "application system error?")})
	public PasswordResetResponse resetPasswordPreCheck(@PathParam("trackingid") String trackingID) throws ShackResourceException;
	
	
	
	@POST
	@Path("/resetpassword")
	@ApiOperation(value = "Shack API to for  resetpassword", notes = "This is a shack Endpoint to forgotPassword")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response from API"),
			@ApiResponse(code = 400, message = "Input fields validation error?"),
			@ApiResponse(code = 412, message = "business fields validation error?"),
			@ApiResponse(code = 500, message = "application system error?")})
	public List<String> resetPassword(PasswordResetRequestDTO loginDTO) throws ShackResourceException ;
	
	
	@POST
	@Path("/notifymemberactivation")
	@ApiOperation(value = "Shack API to for  notify MemberActivation", notes = "This is a shack Endpoint to MemberActivation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response from API"),
			@ApiResponse(code = 400, message = "Input fields validation error?"),
			@ApiResponse(code = 412, message = "business fields validation error?"),
			@ApiResponse(code = 500, message = "application system error?")})
	public List<String> notifyMemberActivation(LoginBaseDTO loginBaseDTO) throws ShackResourceException ;

	@PUT
	@Path("/activatemember/{trackingid}")
	@ApiOperation(value = "Shack API to activate the member profile", notes = "This is a shack Endpoint to activate member")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response from API"),
			@ApiResponse(code = 400, message = "Input fields validation error?"),
			@ApiResponse(code = 412, message = "business fields validation error?"),
			@ApiResponse(code = 500, message = "application system error?")})
	public List<String> activateMemberProfile(@PathParam("trackingid") String trackingID) throws ShackResourceException;
}
