package com.example.stable_management.stbl_backend.dtos.stall_dto;

import com.example.stable_management.stbl_backend.dtos.horse_dto.HorseDtoForStallRequest;
import com.example.stable_management.stbl_backend.entities.Stall;
import lombok.Builder;

@Builder
public record StallDtoForStallLocationRequest(
        Long id,
        String name,
        boolean isOccupied,
        HorseDtoForStallRequest horseDto) {
    public static  StallDtoForStallLocationRequest getDto(Stall stall) {
        if (stall == null) return null;
        return builder()
                .id(stall.getId())
                .name(stall.getName())
                .isOccupied(stall.getIsOccupied())
                .horseDto(HorseDtoForStallRequest.getDto(stall.getHorse()))
                .build();
    }
}
