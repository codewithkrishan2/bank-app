package com.bank.exception.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.exception.BankNotFoundException;
import com.bank.exception.BranchNotFoundException;
import com.bank.exception.ServiceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(BankNotFoundException.class)
	    public String handleBankNotFoundException(BankNotFoundException ex, Model model) {
	        model.addAttribute("error", ex.getMessage());
	        return "error";
	    }

	    @ExceptionHandler(BranchNotFoundException.class)
	    public String handleBranchNotFoundException(BranchNotFoundException ex, Model model) {
	        model.addAttribute("error", ex.getMessage());
	        return "error";
	    }

	    @ExceptionHandler(ServiceNotFoundException.class)
	    public String handleServiceNotFoundException(ServiceNotFoundException ex, Model model) {
	        model.addAttribute("error", ex.getMessage());
	        return "error";
	    }

	    @ExceptionHandler(Exception.class)
	    public String handleGeneralException(Exception ex, Model model) {
	        model.addAttribute("error", "An unexpected error occurred: " + ex.getMessage());
	        return "error";
	    }
}
