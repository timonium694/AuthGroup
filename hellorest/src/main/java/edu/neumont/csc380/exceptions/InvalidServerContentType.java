package edu.neumont.csc380.exceptions;

public class InvalidServerContentType extends Exception {
	
	static String message = "The content type sent was not accepted. Please send JSON";
	
	public InvalidServerContentType() {
		super(message);
	}
}
