package edu.neumont.csc380.hello.service;
import java.io.IOException;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.auth.Authorization.Encryptor;
import edu.neumont.csc380.auth.interfaces.IAuthService;
import edu.neumont.csc380.exceptions.InvalidPasswordException;
import edu.neumont.csc380.exceptions.InvalidServerContentTypeException;

@Service("authService")
public class AuthServiceImpl implements IAuthService {

	public Response authorizeUser() {
		return null;
	}

	public Response updateUserPassword() {
		UserFactory uf = new UserFactory();
		uf.updateUserPass(0, "theNewPass");
		return Response.ok("{\"token\": \"1098as7dfasfdGIOas09fd\" }").build();
	}

	public Response deleteUser(int id) {
		UserFactory uf = new UserFactory();
		uf.deleteUser(0);
		return Response.ok("{\"token\": \"1098as7dfasfdGIOas09fd\" }").build();
	}
	public Response retrieveUser()
	{
		try
		{
			
			UserFactory uf = new UserFactory();
			User u = uf.retrieveUser(0);
			return Response.ok(u).build();
		}
		catch(Exception ex)
		{
			
		}
		return Response.ok("Failure to retrieve user").build();
	}

	public Response createUser()
	{
		Response response = null;
			User u = new User();
			u.setAuthLevel(AuthorityLevel.Admin);
			u.setId(0);
			u.setPassword("password");
			u.setUsername("newUser");
			UserFactory uf = new UserFactory();
			uf.createNewUser(u);
			AuthUser authUser = new AuthUser(u.getId(), u.getAuthLevel(), u.getUsername());
			String message = "User " + u.getUsername() + " with the user id" + u.getId() + " and the authority level" + u.getAuthLevel() + " has been created";
			
			try {
				Encryptor encryptor = new Encryptor();
				response = Response.ok(encryptor.encryptUser(authUser, message)).build();
			} catch (Exception e) {
				response = Response.status(500).entity("There was a problem with the encryption of the user").build();
				e.printStackTrace();
			}
			finally
			{
				return response;
			}
	}
	
	public String updateUserPassword(int id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public String retrieveUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
