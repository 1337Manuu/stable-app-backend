package com.example.stable_management.stbl_backend.dtos.horse_dto;

import com.example.stable_management.stbl_backend.dtos.tenant_dto.TenantDtoForHorseRequest;
import com.example.stable_management.stbl_backend.entities.Horse;
import com.example.stable_management.stbl_backend.entities.Tenant;
import lombok.Builder;

@Builder
public record HorseDtoForStallRequest(Long id,
                                      String name,
                                      TenantDtoForHorseRequest tenantDto) {
    public static HorseDtoForStallRequest getDto(Horse horse) {
        if (horse == null) return null;
        return HorseDtoForStallRequest.builder()
                .id(horse.getId())
                .name(horse.getName())
                .tenantDto(TenantDtoForHorseRequest.getDto(horse.getTenant()))
                .build();
    }
}
