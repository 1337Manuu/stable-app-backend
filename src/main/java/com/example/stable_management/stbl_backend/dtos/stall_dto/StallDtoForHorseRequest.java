package com.example.stable_management.stbl_backend.dtos.stall_dto;

import com.example.stable_management.stbl_backend.dtos.stall_location_dto.StallLocationDtoForStallRequest;
import com.example.stable_management.stbl_backend.entities.Stall;
import lombok.Builder;

@Builder
public record StallDtoForHorseRequest(
        Long id,
        StallLocationDtoForStallRequest stallLocationDto
) {
    public static StallDtoForHorseRequest getDto(Stall stall) {
        if (stall == null) return null;
        return StallDtoForHorseRequest.builder()
                .id(stall.getId())
                .stallLocationDto(StallLocationDtoForStallRequest.getDto(stall.getStallLocation()))
                .build();
    }
}

