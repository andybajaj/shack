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
import com.gaming.shack.data.model.UserDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// TODO: Auto-generated Javadoc
/**
 * The Interface IShackRegistrationResource.
 */
@Path("/registration")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/registration", tags = "registration")
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
	@ApiOperation(value = "Shack Find  Users API", notes = "This is a shack Endpoint to find all users")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success Response from API"),
			@ApiResponse(code = 400, message = "Input fields validation error?"),
			@ApiResponse(code = 412, message = "business fields validation error?"),
			@ApiResponse(code = 500, message = "application system error?")})
	public ItemList<UserDTO> findAllUsers(@Context UriInfo ui) throws ShackResourceException;
	
	/**
	 * The resource service level method for adding the member
	 * @param memberProfile
	 * @return
	 * @throws ShackResourceException
	 */
	@POST
	@Path("/addmembermaster")
	public ItemList<MemberDTO> addMemberMaster(MemberDTO member) throws ShackValidationException , ShackResourceException ; 
	

}