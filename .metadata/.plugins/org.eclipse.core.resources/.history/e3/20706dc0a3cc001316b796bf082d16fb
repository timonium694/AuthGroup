package edu.neumont.csc380.hello.service;

import javax.xml.bind.annotation.XmlRootElement;

import edu.neumont.csc380.auth.Authorization.AuthorityLevel;

@XmlRootElement
public class AuthUser {
	private int id;
	private AuthorityLevel authorityLevel;
	
	public AuthUser(int id, AuthorityLevel authorityLevel) {
		super();
		this.id = id;
		this.authorityLevel = authorityLevel;
	}
	
	public int getId() {
		return id;
	}
	public AuthorityLevel getAuthorityLevel() {
		return authorityLevel;
	}
}
