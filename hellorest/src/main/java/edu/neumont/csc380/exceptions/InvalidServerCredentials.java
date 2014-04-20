package edu.neumont.csc380.exceptions;

public class InvalidServerCredentials extends Exception {

	static String message = "The credentials that were sent are not accepted.";
	
	public InvalidServerCredentials() {
		super(message);
	}
	
}
