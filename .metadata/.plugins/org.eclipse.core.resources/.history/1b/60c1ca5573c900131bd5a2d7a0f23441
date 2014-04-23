package edu.neumont.csc380.hello.service;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.stereotype.Service;

import edu.neumont.csc380.auth.interfaces.IAuthService;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements IAuthService {

	public String authorizeUser() {
		
		return null;
	}

	public String updateUserPassword() {
		UserFactory uf = new UserFactory();
		uf.updateUserPass(0, "theNewPass");
		return "{\"token\", \"1098as7dfasfdGIOas09fd\" }";
	}

	public String deleteUser() {
		UserFactory uf = new UserFactory();
		uf.deleteUser(0);
		return "{\"token\", \"1098as7dfasfdGIOas09fd\" }";
	}
	public String retrieveUser()
	{
		try
		{
			
			UserFactory uf = new UserFactory();
			User u = uf.retrieveUser(0);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			return ow.writeValueAsString(u);
		}
		catch(Exception ex)
		{
			
		}
		return "Failure to retrieve user";
	}

	public String createUser()
	{
		try
		{
			User u = new User();
			u.setAuthLevel("Admin");
			u.setId(0);
			u.setPassword("password");
			u.setUsername("newUser");
			UserFactory uf = new UserFactory();
			uf.createNewUser(u);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			return ow.writeValueAsString(u);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "failure to create new user";
	}

	

	
	

}
