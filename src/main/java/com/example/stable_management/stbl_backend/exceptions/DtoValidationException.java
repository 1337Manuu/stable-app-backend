package com.example.stable_management.stbl_backend.exceptions;

public class DtoValidationException extends RuntimeException {

    public DtoValidationException(String message) {
        super(message);
    }
}
