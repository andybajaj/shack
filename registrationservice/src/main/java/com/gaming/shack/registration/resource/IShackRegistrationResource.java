/*
 * 
 */
package com.gaming.shack.registration.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gaming.shack.core.exception.ShackResourceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.core.model.ItemList;
import com.gaming.shack.data.model.MemberDTO;
import com.gaming.shack.data.model.MemberSuccess;
import com.gaming.shack.data.model.UserDTO;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// TODO: Auto-generated Javadoc
/**
 * The Interface IShackRegistrationResource.
 */
@Path("/registration")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IShackRegistrationResource {

	
	/**
	 * Find all users.
	 *
	 * @param ui the ui
	 * @return the item list
	 * @throws ShackResourceException the shack resource exception
	 */
	@GET
	@Path("/findallusers")
	public ItemList<UserDTO> findAllUsers(@Context UriInfo ui) throws ShackResourceException;
	
	/**
	 * The resource service level method for adding the member
	 * @param memberProfile
	 * @return
	 * @throws ShackResourceException
	 */
	@POST
	@Path("/addmembermaster")
	//ApiOperation(value = "Shack API for add member", notes = "This is a shack Endpoint add member")  
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response from API"),  
	@ApiResponse(code = 400, message = "Input fields validation error?"),  
	@ApiResponse(code = 412, message = "business fields validation error?"),  
	@ApiResponse(code = 500, message = "application system error?")})  

	public ItemList<MemberSuccess> addMemberMaster(MemberDTO member) throws ShackValidationException , ShackResourceException ; 
	
	/**
	 * The service will be used to update the member master
	 * @param member
	 * @return
	 * @throws ShackValidationException
	 * @throws ShackResourceException
	 */
	@POST
	@Path("/updatemembermaster")
	//ApiOperation(value = "Shack API for update member", notes = "This is a shack Endpoint update member")  
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response from API"),  
	@ApiResponse(code = 400, message = "Input fields validation error?"),  
	@ApiResponse(code = 412, message = "business fields validation error?"),  
	@ApiResponse(code = 500, message = "application system error?")})  

	public ItemList<MemberSuccess> updateMemberMaster(MemberDTO member) throws ShackValidationException , ShackResourceException ;
	
}