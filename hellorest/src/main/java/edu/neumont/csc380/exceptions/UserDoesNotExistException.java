package edu.neumont.csc380.exceptions;

public class UserDoesNotExistException extends RuntimeException {
	
	static String message = "The user that is being reqeusted doesn't exists";
	
	public UserDoesNotExistException() {
		super(message);
	}
	
}
