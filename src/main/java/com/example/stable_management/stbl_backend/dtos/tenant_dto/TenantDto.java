package com.example.stable_management.stbl_backend.dtos.tenant_dto;

import com.example.stable_management.stbl_backend.dtos.hall_booking_dto.HallBookingDtoForTenantRequest;
import com.example.stable_management.stbl_backend.dtos.horse_dto.HorseDtoForTenantRequest;
import com.example.stable_management.stbl_backend.entities.Tenant;
import lombok.Builder;

import java.util.List;

@Builder
public record TenantDto(
        Long id,
        String name,
        String phone,
        List<HorseDtoForTenantRequest> horseDtoList,
        List<HallBookingDtoForTenantRequest> hallBookingDtoList) {
    public static TenantDto getDto(Tenant tenant) {
        if (tenant == null) return null;
        return TenantDto.builder()
                .id(tenant.getId())
                .name(tenant.getName())
                .phone(tenant.getPhone())
                .horseDtoList(tenant.getHorses()
                        .stream()
                        .map(HorseDtoForTenantRequest::getDto).toList())
                .hallBookingDtoList(tenant.getHallBookings()
                        .stream()
                        .map(HallBookingDtoForTenantRequest::getDto).toList())
                .build();

    }
}
