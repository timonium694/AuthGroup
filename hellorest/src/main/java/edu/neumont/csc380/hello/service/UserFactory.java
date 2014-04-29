package edu.neumont.csc380.hello.service;

import java.io.IOException;
import java.util.ArrayList;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;

public class UserFactory {

	private static ArrayList<User> users = new ArrayList<User>();
	private static int currentId = 0;
	
	public ArrayList<User> getUsers()
	{
		return this.users;
	}
	public Boolean updateUserPass(int id, String newPass) 
	{
		Boolean updated = false;
		for(User u : this.users)
		{
			if(u.getId()==id)
			{
				u.setPassword(newPass);
				updated = true;
				break;
			}
		}
		
		
//		ObjectMapper mapper = new ObjectMapper();
//
//		User user = null;
//		try
//		{
//			user = mapper.readValue(new File("src/main/resources/"+id+".json"), User.class);
//			user.setPassword(newPass);
//			updated=true;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//			
//		 if(updated)
//		 {
//			 try {
//				mapper.writeValue(new File("src/main/resources"+id+".json"), user);
//			} catch (JsonGenerationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		 
//		 }
		 return updated;
	}
	public Boolean createNewUser(User u)
	{
		Boolean created = false;
		u.setId(this.currentId++);
		this.users.add(u);
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			mapper.writeValue(new File("src/main/resources"+u.getId()+".json"), u);
//			created = true;
//		} catch (JsonGenerationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return  created;
	}
	public AuthorityLevel getAuthenticationLevel(int id)
	{
		AuthorityLevel output = null;

//		ObjectMapper mapper = new ObjectMapper();
//
//		User user = null;
//		try
//		{
//			user = mapper.readValue(new File("src/main/resources/"+id+".json"), User.class);
//			output = user.getAuthLevel();
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		for(User u : this.users)
		{
			if(u.getId()==id)
			{
				output = u.getAuthLevel();
				break;
			}
		}
		
		
		 return output;
	}
	public User retrieveUser(int id)
	{
		User user = null;
		for(User u : this.users)
		{
			if(u.getId()==id)
			{
				user=u;
				break;
			}
		}
		return user;
	}
	public Boolean deleteUser(String userName)
	{
		Boolean deleted = false;
//		try
//		{
//			File f = new File("src/main/resources/"+id+".json");
//			f.delete();
//			deleted=true;
//		}
//		catch(Exception ex)
//		{
//			ex.printStackTrace();
//		}
		for(int i = 0; i<users.size();i++)
		{
			if(users.get(i).getUsername().equals(userName))
			{
				users.remove(i);
			}
		}
		return deleted;
	}
}
