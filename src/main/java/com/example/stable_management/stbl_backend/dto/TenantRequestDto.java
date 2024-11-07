package com.example.stable_management.stbl_backend.dto;

import com.example.stable_management.stbl_backend.entities.Horse;

import java.util.List;
import java.util.Set;

public record TenantRequestDto(
        String name,
        String phone,
        List<String> horses) {
}
