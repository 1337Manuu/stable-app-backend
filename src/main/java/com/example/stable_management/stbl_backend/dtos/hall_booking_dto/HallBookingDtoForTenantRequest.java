package com.example.stable_management.stbl_backend.dtos.hall_booking_dto;

import com.example.stable_management.stbl_backend.entities.HallBooking;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record HallBookingDtoForTenantRequest(
        Long id,
        String name,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
    public static HallBookingDtoForTenantRequest getDto(HallBooking hallBooking) {
        return builder()
                .id(hallBooking.getId())
                .name(hallBooking.getName())
                .startTime(hallBooking.getStartTime())
                .endTime(hallBooking.getEndTime())
                .build();
    }
}
