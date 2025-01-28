package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.dtos.HorseDto;
import com.example.stable_management.stbl_backend.entities.Horse;

import java.util.List;

public interface HorseService {
    List<Horse> getAllHorses();

    Horse getHorseById(Long id);

    Horse createHorse(HorseDto horseDto);

    void validate(HorseDto horseDto);

    Horse assignHorseToTenant(Long tenantId, Long horseId);

    Horse assignHorseToStall(Long stallId, Long horseId);

    Horse assignFeedScheduleToHorse(Long horseId, Long feedScheduleId);
}
