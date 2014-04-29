package edu.neumont.csc380.hello.service;
import java.util.ArrayList;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;
import edu.neumont.csc380.exceptions.InvalidPasswordException;
import edu.neumont.csc380.exceptions.UserAlreadyExistsException;

public class UserFactory {

	private static ArrayList<User> users = new ArrayList<User>();
	private static int currentId = 0;
	
	public ArrayList<User> getUsers()
	{
		return this.users;
	}
	public User updateUserPass(String userName, String oldPass, String newPass) 
	{
		User updatedUser = null;
		for(User u : this.users)
		{
			if(u.getUsername().equals(userName))
			{
				if(!u.getPassword().equals(oldPass))
				{
					throw new InvalidPasswordException();
				}
				u.setPassword(newPass);
				updatedUser = u;
				break;
			}
		}
		
		return updatedUser;
	}
	public Boolean createNewUser(User u)
	{
		Boolean created = false;
		u.setId(this.currentId++);
		for(User user : users)
		{
			if(user.getUsername().equals(u.getUsername()))
			{
				throw new UserAlreadyExistsException();
			}
		}
		this.users.add(u);
		return  created;
	}
	public AuthorityLevel getAuthenticationLevel(int id)
	{
		AuthorityLevel output = null;


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
	public User retrieveUser(String userName,String password)
	{
		User user = null;
		for(User u : this.users)
		{
			if(u.getUsername().equals(userName))
			{
				if(u.getPassword().equals(password))
				{
					user=u;
				}
				break;
			}
		}
		return user;
	}
	public Boolean deleteUser(String userName)
	{
		Boolean deleted = false;

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
