package com.example.stable_management.stbl_backend.dtos;

public record FeedingDto(
        String time,
        Long scheduleId,
        Long typeId,
        Long servingSizeId
) {
}
