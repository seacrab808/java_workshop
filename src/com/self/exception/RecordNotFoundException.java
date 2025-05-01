package com.self.exception;

@SuppressWarnings("serial")
public class RecordNotFoundException extends Exception{
	public RecordNotFoundException(String message) {
		super(message);
	}
}
