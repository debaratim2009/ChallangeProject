package com.example.codingchallange.exception;

public class ValidationException extends RuntimeException {
	String description;

	public ValidationException(Throwable cause, String description) {
		super(cause);
		this.description = description;
	}
	
	public ValidationException( String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ValidationException{" + "description='" + description + '\'' + '}';
	}

}
