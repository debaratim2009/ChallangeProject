package com.example.codingchallange.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ControllerExceptionHandler {
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<String> validationException(ValidationException ex, HttpServletRequest request) {
		return new ResponseEntity<>(ex.description, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Handles all other exceptions
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> globalExceptionHandler(Exception ex, HttpServletRequest request) {
		String exMessage = ex.getMessage();
		return new ResponseEntity<>(exMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
		String exMessage = ex.getMessage();
		return new ResponseEntity<>(exMessage+ex.description, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
