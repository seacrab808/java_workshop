package com.self.exception;

@SuppressWarnings("serial")
public class InvalidBookTypeException extends Exception{
	public InvalidBookTypeException() {
		this("This is a InvalidBookTypeException...");
	}
	public InvalidBookTypeException(String message) {
		super(message);
	}
}
