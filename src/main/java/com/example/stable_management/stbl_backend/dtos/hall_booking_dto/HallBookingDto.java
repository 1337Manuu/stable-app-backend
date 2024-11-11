package com.example.stable_management.stbl_backend.dtos.hall_booking_dto;

import com.example.stable_management.stbl_backend.dtos.tenant_dto.TenantDtoForHallBookingRequest;
import com.example.stable_management.stbl_backend.entities.HallBooking;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record HallBookingDto(Long id,
                             String name,
                             LocalDateTime startTime,
                             LocalDateTime endTime,
                             TenantDtoForHallBookingRequest tenantDto) {
    public static HallBookingDto getDto(HallBooking hallBooking) {
        if (hallBooking == null) {return null;}
        return HallBookingDto.builder()
                .id(hallBooking.getId())
                .name(hallBooking.getName())
                .startTime(hallBooking.getStartTime())
                .endTime(hallBooking.getEndTime())
                .tenantDto(TenantDtoForHallBookingRequest.getDto(hallBooking.getTenant()))
                .build();
    }
}
