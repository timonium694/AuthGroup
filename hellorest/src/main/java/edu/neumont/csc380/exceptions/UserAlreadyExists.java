package edu.neumont.csc380.exceptions;

public class UserAlreadyExists extends Exception {
	
	static String message = "The user being asked to be created already exists.";
	
	public UserAlreadyExists() {
		super(message);
	}
}
