package com.self.exception;

@SuppressWarnings("serial")
public class DuplicateIsbnException extends RuntimeException {
	public DuplicateIsbnException() {
		this("This is a DuplicateTitleException...");
	}
    public DuplicateIsbnException(String message) {
        super(message);
    }
}
