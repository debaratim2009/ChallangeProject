package com.example.codingchallange.exception;

public class ResourceNotFoundException extends RuntimeException {
	String description;

	public ResourceNotFoundException(Throwable cause, String description) {
		super(cause);
		this.description = description;
	}
	
	public ResourceNotFoundException( String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ResourceNotFoundException{" + "description='" + description + '\'' + '}';
	}

}
