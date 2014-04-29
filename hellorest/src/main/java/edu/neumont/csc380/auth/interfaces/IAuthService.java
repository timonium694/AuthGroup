package edu.neumont.csc380.auth.interfaces;

import java.io.IOException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import edu.neumont.csc380.exceptions.UserDoesNotExistException;
import edu.neumont.csc380.hello.service.AuthCredentialsV1;

@Path("/auth")
public interface IAuthService {
	@POST
	@Path("/authorize")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	public Response authorizeUser(AuthCredentialsV1 streetCred) throws UserDoesNotExistException, IOException;

	@POST
	@Path("/updatePass")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	public Response updateUserPassword(AuthCredentialsV1 streetCred)  throws UserDoesNotExistException, IOException;
	
	@DELETE
	@Path("/deleteUser")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	public Response deleteUser(AuthCredentialsV1 streetCred) throws UserDoesNotExistException;
	
	@POST
	@Path("/create")
	@Consumes("application/vnd.neumont.auth.edu-v1+json")
	public Response createUser(AuthCredentialsV1 streetCred);
}
