package com.example.stable_management.stbl_backend.dtos;

public record HorseDto(
        String name,
        Long tenantId,
        Long stallId
) {
}
