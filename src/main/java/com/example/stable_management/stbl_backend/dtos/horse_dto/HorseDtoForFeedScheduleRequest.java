package com.example.stable_management.stbl_backend.dtos.horse_dto;

import com.example.stable_management.stbl_backend.dtos.stall_dto.StallDtoForHorseRequest;
import com.example.stable_management.stbl_backend.entities.Horse;
import lombok.Builder;

@Builder
public record HorseDtoForFeedScheduleRequest(
        Long id,
        String name,
        StallDtoForHorseRequest stallDto
) {
    public static HorseDtoForFeedScheduleRequest getDto(Horse horse) {
        if (horse == null) return null;
        return builder()
                .id(horse.getId())
                .name(horse.getName())
                .stallDto(StallDtoForHorseRequest.getDto(horse.getStall()))
                .build();
    }
}
