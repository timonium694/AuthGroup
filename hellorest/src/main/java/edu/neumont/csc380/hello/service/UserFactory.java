package edu.neumont.csc380.hello.service;

import java.util.ArrayList;
import edu.neumont.csc380.auth.Authorization.AuthorityLevel;

public class UserFactory {

	private static ArrayList<User> users = new ArrayList<User>();
	private static int currentId = 0;
	public ArrayList<User> getUsers()
	{
		return UserFactory.users;
	}
	public Boolean updateUserPass(int id, String newPass) 
	{
		
		boolean updated = false;
		for(User u : UserFactory.users)
		{
			if(u.getId()==id)
			{
				u.setPassword(newPass);
				updated = true;
				break;
			}
		}
		
		return updated;
	}
	public Boolean createNewUser(User u)
	{
		Boolean created = false;
		u.setId(UserFactory.currentId++);
		UserFactory.users.add(u);

		return  created;
	}
	public AuthorityLevel getAuthenticationLevel(int id)
	{
		AuthorityLevel output = null;


		for(User u : UserFactory.users)
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
		for(User u : UserFactory.users)
		{
			if(u.getId()==id)
			{
				user=u;
				break;
			}
		}
		return user;
	}
	public Boolean deleteUser(int id)
	{
		Boolean deleted = false;

		for(int i = 0; i<users.size();i++)
		{
			if(users.get(i).getId()==id)
			{
				users.remove(i);
			}
		}
		return deleted;
	}
}
