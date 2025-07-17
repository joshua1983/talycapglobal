package com.josue.technicaltest.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {

      Map<String, String> errors = new HashMap<>();
      ex.getBindingResult()
         .getFieldErrors()
         .forEach(error -> errors.put(error.getField(), error.getDefaultMessage())
         );
      return ResponseEntity.badRequest().body(errors);
   }


   @ExceptionHandler({AuthenticationTokenException.class, BadCredentialsException.class})
   public ResponseEntity<String> handleAuthenticationTokenException(AuthenticationTokenException ex) {

      return ResponseEntity.status(401).body(ex.getMessage());
   }
}
