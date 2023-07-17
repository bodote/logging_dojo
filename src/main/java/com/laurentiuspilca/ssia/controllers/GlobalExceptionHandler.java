package com.laurentiuspilca.ssia.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<String> handleValidationException(AuthenticationException ex) {
    // Log the exception and the response here

    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
  }
}