package edu.neumont.csc380.auth.client;


import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.MessageProcessingException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.auth.Authorization.Encryptor;
import edu.neumont.csc380.auth.interfaces.IAuthService;
import edu.neumont.csc380.exceptions.InvalidTokenException;
import edu.neumont.csc380.exceptions.UserDoesNotExistException;
import edu.neumont.csc380.hello.service.AuthCredentialsV1;
import edu.neumont.csc380.hello.service.AuthTokenV1;
import edu.neumont.csc380.hello.service.AuthUser;


public class AuthClientImpl{
	private final IAuthService proxy = JAXRSClientFactory.create ( "http://localhost:8080/hellorest-server/rest", IAuthService.class);
	
	public AuthUser createUser(String userName,String password,String serverCredentials,AuthorityLevel authority) throws InvalidTokenException, UserDoesNotExistException
	{
		AuthCredentialsV1 streetCred = new AuthCredentialsV1(userName, password, serverCredentials, authority);
		AuthUser authUser = null;
		Response r = proxy.createUser(streetCred);
		System.out.println(r);
		System.out.println(r.getStatus());
		System.out.println(r.readEntity(AuthTokenV1.class).getToken());
		Encryptor encryptor = new Encryptor();
		try {
			authUser = encryptor.DecryptCredentials(r.readEntity(AuthTokenV1.class));
			System.out.println(authUser.getAuthorityLevel());
		} catch (MessageProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return authUser;
		}
	}
	
	public AuthUser authenticateUser(String userName,String password,String serverCredentials) throws UserDoesNotExistException
	{
		AuthCredentialsV1 streetCred = new AuthCredentialsV1(userName, password, serverCredentials, null);
		AuthUser authUser = null;
		try {
			Response r = proxy.authorizeUser(streetCred);
			System.out.println(r);
			System.out.println(r.getStatus());
			System.out.println(r.readEntity(AuthTokenV1.class).getToken());
			Encryptor encryptor = new Encryptor();
			authUser = encryptor.DecryptCredentials(r.readEntity(AuthTokenV1.class));
			System.out.println(authUser.getAuthorityLevel());
		} catch (MessageProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return authUser;
		}
	}
	
	public AuthUser deleteUser(String userName,String password,String serverCredentials) throws UserDoesNotExistException
	{
		AuthCredentialsV1 streetCred = new AuthCredentialsV1(userName, password, serverCredentials, null);
		AuthUser authUser = null;
		Response r = proxy.deleteUser(streetCred);
		System.out.println(r);
		System.out.println(r.getStatus());
		System.out.println(r.readEntity(AuthTokenV1.class).getToken());
		Encryptor encryptor = new Encryptor();
		try {
			authUser = encryptor.DecryptCredentials(r.readEntity(AuthTokenV1.class));
			System.out.println(authUser.getAuthorityLevel());
		} catch (MessageProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return authUser;
		}
	}

	
	public AuthUser updateUser(String userName,String password,String serverCredentials,String updatedPassword) throws UserDoesNotExistException
	{
		AuthCredentialsV1 streetCred = new AuthCredentialsV1(userName, password, serverCredentials, null);
		streetCred.setExtraData(updatedPassword);
		AuthUser authUser = null;
		try {
			Response r = proxy.updateUserPassword(streetCred);
			System.out.println(r);
			System.out.println(r.getStatus());
			System.out.println(r.readEntity(AuthTokenV1.class).getToken());
			Encryptor encryptor = new Encryptor();
			authUser = encryptor.DecryptCredentials(r.readEntity(AuthTokenV1.class));
			System.out.println(authUser.getAuthorityLevel());
		} catch (MessageProcessingException e) {
			e.printStackTrace();
		}
		finally
		{
			return authUser;
		}
	}
}
