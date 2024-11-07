package com.example.stable_management.stbl_backend.dto;

import com.example.stable_management.stbl_backend.entities.Tenant;
import lombok.Builder;

@Builder
public record HorseRequestDto (
        String name,
        Tenant tenant){

}
