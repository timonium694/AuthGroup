package edu.neumont.csc380.auth.interfaces;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/auth")
public interface IAuthService {
	@POST
	@Path("/authorize")
	@Produces("application/vnd.neumont.auth.edu-v1+json")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	public Response authorizeUser();
	
	@POST
	@Path("/updatePass")
	@Produces("application/vnd.neumont.auth.edu-v1+json")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	public Response updateUserPassword();
	
	@POST
	@Path("/deleteUser")
	@Produces("application/vnd.neumont.auth.edu-v1+json")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	public Response deleteUser();
	
	@GET
	@Path("/create")
	@Produces("application/json")
	public Response createUser();
	
	@GET
	@Path("/retrieve")
	@Produces("application/vnd.neumont.auth.edu-v1+json")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	public Response retrieveUser();
}
