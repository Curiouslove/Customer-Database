package com.crowninteractive.customerdatabase.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public @ResponseBody HttpErrorMessage handleResourceNotFoundExceptions(HttpServletRequest request, Exception message){
        return createHttpErrorMessage(HttpStatus.NOT_FOUND, request, message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public @ResponseBody HttpErrorMessage handleBadRequestExceptions(HttpServletRequest request, Exception message){
        return createHttpErrorMessage(HttpStatus.BAD_REQUEST, request, message);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public @ResponseBody HttpErrorMessage handleJsonParseErrors(HttpServletRequest request, Exception message){
        return createHttpErrorMessage(HttpStatus.BAD_REQUEST, request, message);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CustomerDatabaseException.class)
    public @ResponseBody HttpErrorMessage handleInternalServerExceptions(HttpServletRequest request, Exception message){
        return createHttpErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, request, message);
    }

    private HttpErrorMessage createHttpErrorMessage(HttpStatus httpStatus, HttpServletRequest request, Exception ex) {
        final String path = request.getServletPath();
        final String message = ex.getMessage();

        log.debug("Returning HTTP status: {} for path: {}, message: {}", httpStatus, path, message);
        return new HttpErrorMessage(httpStatus, path, message);
    }
}
