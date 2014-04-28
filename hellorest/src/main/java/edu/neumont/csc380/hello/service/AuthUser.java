package edu.neumont.csc380.hello.service;

import javax.xml.bind.annotation.XmlRootElement;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;

@XmlRootElement
public class AuthUser {
	private int id;
	private String username;
	private AuthorityLevel authorityLevel;
	
	public AuthUser(int id, AuthorityLevel authorityLevel, String username) {
		super();
		this.username = username;
		this.id = id;
		this.authorityLevel = authorityLevel;
	}
	
	public int getId() {
		return id;
	}
	public AuthorityLevel getAuthorityLevel() {
		return authorityLevel;
	}
	public String getUsername() {
		return username;
	}
	public String toString()
	{
		return "ID: " + this.id + " Username: " + this.username + " AuthLevel: " +this.authorityLevel;
	}
}
