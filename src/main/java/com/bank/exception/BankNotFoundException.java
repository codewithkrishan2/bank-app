package com.bank.exception;

public class BankNotFoundException extends RuntimeException {
    public BankNotFoundException(String message) {
        super(message);
    }
}
