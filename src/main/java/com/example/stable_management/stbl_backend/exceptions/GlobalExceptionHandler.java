package com.example.stable_management.stbl_backend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e){
        return new ResponseEntity<>(
                new ErrorResponse(
                       e.getMessage(),
                       HttpStatus.NOT_FOUND.value()
               ),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(DtoValidationException.class)
    public ResponseEntity<ErrorResponse> handleDtoValidationException(DtoValidationException e){
        return new ResponseEntity<>(
                new ErrorResponse(
                        e.getMessage(),
                        HttpStatus.BAD_REQUEST.value()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

}
