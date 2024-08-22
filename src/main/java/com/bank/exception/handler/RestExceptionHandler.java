package com.bank.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bank.exception.BankNotFoundException;
import com.bank.exception.BranchNotFoundException;
import com.bank.exception.ServiceNotFoundException;

@RestControllerAdvice
public class RestExceptionHandler {

	 @ExceptionHandler(BankNotFoundException.class)
	    public ResponseEntity<String> handleBankNotFoundException(BankNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(BranchNotFoundException.class)
	    public ResponseEntity<String> handleBranchNotFoundException(BranchNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(ServiceNotFoundException.class)
	    public ResponseEntity<String> handleServiceNotFoundException(ServiceNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGeneralException(Exception ex) {
	        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
