package com.self.exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends Exception {
	public BookNotFoundException() {
		this("This is a BookNotFoundException...");
	}
	public BookNotFoundException(String message) {
		super(message);
	}
}
