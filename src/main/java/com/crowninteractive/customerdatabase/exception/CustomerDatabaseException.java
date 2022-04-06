package com.crowninteractive.customerdatabase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Status 500
public class CustomerDatabaseException extends RuntimeException{
    public CustomerDatabaseException(String message){
        super(message);
    }

    public CustomerDatabaseException(String message, Throwable cause){
        super(message, cause);
    }

    public CustomerDatabaseException(Throwable cause){
        super(cause);
    }
}
