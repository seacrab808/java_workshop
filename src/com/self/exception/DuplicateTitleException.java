package com.self.exception;

@SuppressWarnings("serial")
public class DuplicateTitleException extends RuntimeException {
	public DuplicateTitleException() {
		this("This is a DuplicateTitleException...");
	}
    public DuplicateTitleException(String message) {
        super(message);
    }
}
