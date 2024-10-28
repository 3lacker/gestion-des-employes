package com.gestion.des.employes.config;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.gestion.des.employes.exception.EmployeeException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<Object> handleException(NoResourceFoundException exception, Locale locale) {
        String message = messageSource.getMessage("no.resource.found", null, locale);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(message);
    }

    @ExceptionHandler(EmployeeException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(EmployeeException ex, Locale locale) {
        String message = messageSource.getMessage("employee.already.exists", null, locale);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex, Locale locale) {
        String message = messageSource.getMessage("general.error", null, locale);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
}