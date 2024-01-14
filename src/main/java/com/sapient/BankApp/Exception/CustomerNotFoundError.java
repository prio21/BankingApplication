package com.sapient.BankApp.Exception;

public class CustomerNotFoundError extends Exception  {

    public CustomerNotFoundError() {
        super();
    }

    public CustomerNotFoundError(String message) {
        super(message);
    }

    public CustomerNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }
}