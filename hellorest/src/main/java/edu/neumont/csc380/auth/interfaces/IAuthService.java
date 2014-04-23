package edu.neumont.csc380.auth.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/auth")
public interface IAuthService {
	@POST
	@Path("/authorize")
	@Produces("application/json")
	@Consumes("application/json")
	String authorizeUser();
	
	@POST
	@Path("/updatePass/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	String updateUserPassword(@PathParam("id") int id, String password);
	
	@DELETE
	@Path("/deleteUser/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	String deleteUser(@PathParam("id") int id);
	
	@PUT
	@Path("/create")
	@Produces("application/json")
	String createUser();
	
	@GET
	@Path("/retrieve/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	String retrieveUser(@PathParam("id") int id);
	
}
