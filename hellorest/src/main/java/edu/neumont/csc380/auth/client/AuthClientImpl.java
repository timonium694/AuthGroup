package edu.neumont.csc380.auth.client;


import java.io.IOException;
import java.net.HttpURLConnection;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import edu.neumont.csc380.auth.interfaces.IAuthService;
import edu.neumont.csc380.hello.service.AuthCredentialsV1;
import edu.neumont.csc380.hello.service.User;


public class AuthClientImpl{
	public static void main(String[] args) throws IOException
	{
		createUser(new AuthCredentialsV1("Tim", "isGay", "Me"));
	}
	
	public static void createUser(AuthCredentialsV1 streetCred) throws IOException
	{
		IAuthService proxy = JAXRSClientFactory.create ( "http://localhost:8080/hellorest-server/rest", IAuthService.class );
		Response r = proxy.createUser();
		System.out.println(r);
		System.out.println(r.getStatus());
		System.out.println(((HttpURLConnection)r.getEntity()).getResponseMessage());
	}
}
