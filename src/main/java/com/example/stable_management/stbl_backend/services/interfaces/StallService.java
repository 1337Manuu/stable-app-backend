package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.dtos.StallDto;
import com.example.stable_management.stbl_backend.entities.Stall;

import java.util.List;

public interface StallService {
    List<Stall> getAllStalls();

    Stall getStallById(Long id);

    Stall createStall(StallDto stallDto);

    Stall assignHorseToStall(Long horseId, Long stallId);

    Stall assignStallToStallLocation(Long stallId, Long stallLocationId);
}
