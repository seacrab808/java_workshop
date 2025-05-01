package com.self.exception;

@SuppressWarnings("serial")
public class DuplicateIsbnException extends RuntimeException {
	public DuplicateIsbnException() {
		this("This is a DuplicateIsbnException...");
	}
    public DuplicateIsbnException(String message) {
        super(message);
    }
}
