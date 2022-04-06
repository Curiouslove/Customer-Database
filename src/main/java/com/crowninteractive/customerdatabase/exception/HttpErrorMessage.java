package com.crowninteractive.customerdatabase.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class HttpErrorMessage {

    private final String path;

    private final HttpStatus httpStatus;

    private final String message;

    private final ZonedDateTime timestamp;

    public HttpErrorMessage(HttpStatus httpStatus, String path, String message) {
        this.path = path;
        this.httpStatus = httpStatus;
        this.message = message;

        timestamp = ZonedDateTime.now();
    }

    public String getPath() {
        return path;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public String getError(){
        return httpStatus.getReasonPhrase();
    }
}
