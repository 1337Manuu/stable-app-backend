package com.example.stable_management.stbl_backend.dtos.stall_dto;

import com.example.stable_management.stbl_backend.dtos.horse_dto.HorseDtoForStallRequest;
import com.example.stable_management.stbl_backend.dtos.stall_location_dto.StallLocationDtoForStallRequest;
import com.example.stable_management.stbl_backend.entities.Stall;
import lombok.Builder;

@Builder
public record StallDto(
        Long id,
        boolean isOccupied,
        HorseDtoForStallRequest horseDto,
        StallLocationDtoForStallRequest stallLocationDto) {
    public static StallDto getDto(Stall stall) {
        if (stall == null) return null;
        if (stall.getIsOccupied() == null) stall.setOccupancyStatus();
        return StallDto.builder()
                .id(stall.getId())
                .isOccupied(stall.getIsOccupied())
                .horseDto(HorseDtoForStallRequest.getDto(stall.getHorse()))
                .stallLocationDto(StallLocationDtoForStallRequest.getDto(stall.getStallLocation()))
                .build();
    }
}
