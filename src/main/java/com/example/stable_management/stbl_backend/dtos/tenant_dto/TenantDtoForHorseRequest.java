package com.example.stable_management.stbl_backend.dtos.tenant_dto;

import com.example.stable_management.stbl_backend.entities.Tenant;
import lombok.Builder;

@Builder
public record TenantDtoForHorseRequest(
        Long id,
        String name,
        String phone
) {
    public static TenantDtoForHorseRequest getDto(Tenant tenant) {
        if (tenant == null) { return null; }
            return TenantDtoForHorseRequest.builder()
                    .id(tenant.getId())
                    .name(tenant.getName())
                    .phone(tenant.getPhone())
                    .build();
    }
}
