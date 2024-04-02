package com.java.javaspringboot.Exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<SimpleResponse> handleProductNotFoundException(CustomBaseException exception){
        return ResponseEntity.status(exception.getStatus()).body(exception.getSimpleResponse());
    }
    @ExceptionHandler(ProductNotValidException.class)
    public ResponseEntity<SimpleResponse> handleProductNotValidException(ProductNotValidException exception){
        return ResponseEntity.status(exception.getStatus()).body(exception.getSimpleResponse());
    }
}
