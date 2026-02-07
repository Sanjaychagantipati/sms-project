package com.sms.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleGeneral(Exception ex){
//		return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleValidation(MethodArgumentNotValidException ex){
	    List<String> errors = ex.getBindingResult()
	                            .getFieldErrors()
	                            .stream()
	                            .map(err -> err.getField() + ": " + err.getDefaultMessage())
	                            .toList();
	    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
