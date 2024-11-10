package com.example.stable_management.stbl_backend.dtos.tenant_dto;

import com.example.stable_management.stbl_backend.entities.Tenant;
import lombok.Builder;

@Builder
public record TenantDtoForHallBookingRequest(
        Long id,
        String name) {
    public static TenantDtoForHallBookingRequest getDto(Tenant tenant) {
        if (tenant == null) { return null; }
        return TenantDtoForHallBookingRequest.builder()
                .id(tenant.getId())
                .name(tenant.getName())
                .build();
    }
}
