package com.crowninteractive.customerdatabase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //Status 404
public class ResourceNotFoundException extends RuntimeException{

    private final String resource;

    private final String field;

    private final String value;

    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("%s not found with %s -> '%s'", resource, field, value));
        this.resource = resource;
        this.field = field;
        this.value = value;
    }

    public String getResource() {
        return resource;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }
}
