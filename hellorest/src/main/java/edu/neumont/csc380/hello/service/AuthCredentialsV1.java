package edu.neumont.csc380.hello.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthCredentialsV1 {
	private String userName;
	private String password;
	private String serverCredentials;
	
	public AuthCredentialsV1(String userName,String password,String serverCredentials)
	{
		this.userName = userName;
		this.password = password;
		this.serverCredentials = serverCredentials;
		
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getServerCredentials() {
		return serverCredentials;
	}
	public String toString()
	{
		return "Server Cred: " + this.serverCredentials + " Username: " + this.userName;
	}
}