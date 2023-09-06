package com.project.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.userservice.payload.ApiResponse;

//this means it can handle any exception in the whole project
@RestControllerAdvice	
public class GlobalExceptionHandler {

	//if anywhere resourceNotFoundException occurs then this exception will be called
	//handlerResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		//builder is used to send all the data in 1 line
		//otherwise all the value will be set by calling particularly
		ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
		
	}
	
}