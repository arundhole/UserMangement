package com.usermangement.app.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
 
public class ControllerAdvice 
{
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handlenullexception(NullPointerException nullpointer)
	{
		return new ResponseEntity<String>("Not matching mail..",HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleallException(Exception exception)
	{
		return new ResponseEntity<String>("Server Down..",HttpStatus.ACCEPTED);
	}

}
