package edu.neumont.csc380.exceptions;

public class InvalidPassword extends Exception {

	static String message = "The password sent was invalid.";
	
	public InvalidPassword() {
		super(message);
	}
	
}
