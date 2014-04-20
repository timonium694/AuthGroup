package edu.neumont.csc380.exceptions;

public class UserDoesNotExist extends Exception {
	
	static String message = "The user that is being reqeusted doesn't exists";
	
	public UserDoesNotExist() {
		super(message);
	}
	
}
