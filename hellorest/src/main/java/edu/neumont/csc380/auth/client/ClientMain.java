package edu.neumont.csc380.auth.client;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.exceptions.InvalidTokenException;
import edu.neumont.csc380.exceptions.UserDoesNotExistException;
import edu.neumont.csc380.hello.service.AuthCredentialsV1;

public class ClientMain {
	public static void main(String[] args)
	{
		AuthClientImpl client = new AuthClientImpl();
		try {
			client.createUser(new AuthCredentialsV1("Tim", "isCanada", "Me",AuthorityLevel.User));
		} catch (InvalidTokenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
