package com.example.stable_management.stbl_backend.exceptions;

import java.time.Instant;

public record ErrorResponse(
        String error,
        Integer status,
        String timestamp
) {
    public ErrorResponse(String error, Integer status) {
        this(error, status, Instant.now().toString());
    }
}