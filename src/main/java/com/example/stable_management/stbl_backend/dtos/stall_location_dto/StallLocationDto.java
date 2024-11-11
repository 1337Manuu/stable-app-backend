package com.example.stable_management.stbl_backend.dtos.stall_location_dto;

import com.example.stable_management.stbl_backend.dtos.stall_dto.StallDtoForStallLocationRequest;
import com.example.stable_management.stbl_backend.entities.StallLocation;
import lombok.Builder;

import java.util.List;

@Builder
public record StallLocationDto(
        Long id,
        String name,
        List<StallDtoForStallLocationRequest> stallDtoList
) {
    public static StallLocationDto getDto(StallLocation stallLocation) {
        if (stallLocation == null) return null;
        return builder()
                .id(stallLocation.getId())
                .name(stallLocation.getName())
                .stallDtoList(stallLocation.getStalls()
                        .stream()
                        .map(StallDtoForStallLocationRequest::getDto)
                        .toList())
                .build();
    }
}
