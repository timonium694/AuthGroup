package edu.neumont.csc380.hello.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthTokenV1 
{
	private String token;
	
	public AuthTokenV1(String token)
	{
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
