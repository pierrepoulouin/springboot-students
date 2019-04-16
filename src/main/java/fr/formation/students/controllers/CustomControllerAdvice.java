package fr.formation.students.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public  class CustomControllerAdvice extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        List<ValidationError> customErrors = new ArrayList<>();
        for (FieldError error : errors) {
            String attributeName = error.getField();
            String errorCode = error.getCode();
            ValidationError customError = new ValidationError();
            customError.setAtributeName(attributeName);
            customError.setAtributeName(errorCode);
            customErrors.add(customError);
        }
        ApiError apiError = new ApiError();
        apiError.setErrors(customErrors);
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setCountErrors(customErrors.size());
        HttpStatus Newstatus = HttpStatus.UNPROCESSABLE_ENTITY;
        apiError.setHttpCode(Newstatus.value());
        apiError.setHttpMessage(Newstatus.getReasonPhrase());
        return new ResponseEntity<Object>(customErrors, headers, status) ;
    }
}