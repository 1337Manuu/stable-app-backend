package com.example.stable_management.stbl_backend.dtos.stall_location_dto;

import com.example.stable_management.stbl_backend.entities.StallLocation;
import lombok.Builder;

@Builder
public record StallLocationDtoForStallRequest(
        Long id,
        String name
) {
    public static StallLocationDtoForStallRequest getDto(StallLocation stallLocation) {
        if (stallLocation == null) return null;
        return builder()
                .id(stallLocation.getId())
                .name(stallLocation.getName())
                .build();
    }
}
