package edu.neumont.csc380.exceptions;

public class InvalidPasswordException extends Exception {

	static String message = "The password sent was invalid.";
	
	public InvalidPasswordException() {
		super(message);
	}
	
}
