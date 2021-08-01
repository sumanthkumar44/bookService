package com.bookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class BookControllerAvice {
	
	@ExceptionHandler
	public ResponseEntity<String> handleQueryException(BookException bookException)
	{
		return new ResponseEntity<String>("No Records found with given input", HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<String> handleQueryException(MethodArgumentTypeMismatchException bookException)
	{
		return new ResponseEntity<String>("Please provide valid input Data", HttpStatus.BAD_REQUEST);
	}

}
