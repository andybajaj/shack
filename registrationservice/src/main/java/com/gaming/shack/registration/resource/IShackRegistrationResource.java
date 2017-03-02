/*
 * 
 */
package com.gaming.shack.registration.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.gaming.shack.core.exception.ShackResourceException;
import com.gaming.shack.core.model.ItemList;
import com.gaming.shack.data.model.UserDTO;

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

}