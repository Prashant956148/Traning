package com.zs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException() {
		super();
	}
	 

}
