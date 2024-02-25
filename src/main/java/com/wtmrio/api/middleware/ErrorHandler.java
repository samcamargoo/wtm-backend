package com.wtmrio.api.middleware;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public NotValidResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        return buildResponse(globalErrors, fieldErrors);
    }

    public NotValidResponse buildResponse(List<ObjectError> globalErrors, List<FieldError> fieldErrors) {
        NotValidResponse notValidResponse = new NotValidResponse();

        globalErrors.forEach(err -> notValidResponse.addGlobalError(err.getDefaultMessage()));
        fieldErrors.forEach(err -> notValidResponse.addFieldError(err.getField(), err.getDefaultMessage()));
        return notValidResponse;
    }
}
