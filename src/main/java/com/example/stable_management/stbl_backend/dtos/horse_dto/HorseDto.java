package com.example.stable_management.stbl_backend.dtos.horse_dto;

import com.example.stable_management.stbl_backend.dtos.feed_schedule_dto.FeedScheduleDtoForHorseRequest;
import com.example.stable_management.stbl_backend.dtos.stall_dto.StallDtoForHorseRequest;
import com.example.stable_management.stbl_backend.dtos.tenant_dto.TenantDtoForHorseRequest;
import com.example.stable_management.stbl_backend.entities.Horse;
import lombok.Builder;

@Builder
public record HorseDto(
        Long id,
        String name,
        TenantDtoForHorseRequest tenantDto,
        StallDtoForHorseRequest stallDto,
        FeedScheduleDtoForHorseRequest feedScheduleDto) {
    public static HorseDto getDto(Horse horse) {
        if (horse == null) return null;
        return HorseDto.builder()
                .id(horse.getId())
                .name(horse.getName())
                .tenantDto(TenantDtoForHorseRequest.getDto(horse.getTenant()))
                .stallDto(StallDtoForHorseRequest.getDto(horse.getStall()))
                .build();

    }
}

