package com.example.stable_management.stbl_backend.dtos.stall_dto;

import com.example.stable_management.stbl_backend.entities.Stall;
import lombok.Builder;

@Builder
public record StallDtoForHorseRequest(
        Long id
) {
    public static StallDtoForHorseRequest getDto(Stall stall) {
        if (stall == null) return null;
        return StallDtoForHorseRequest.builder()
                .id(stall.getId()).build();
    }
}

