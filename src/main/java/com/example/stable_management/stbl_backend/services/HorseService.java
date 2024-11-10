package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.horse_dto.HorseDto;
import com.example.stable_management.stbl_backend.dtos.tenant_dto.TenantDto;
import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import com.example.stable_management.stbl_backend.entities.Horse;
import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.repositories.FeedScheduleRepository;
import com.example.stable_management.stbl_backend.repositories.HorseRepository;
import com.example.stable_management.stbl_backend.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class HorseService {

    private final HorseRepository horseRepository;
    private final TenantRepository tenantRepository;
    private final FeedScheduleRepository feedScheduleRepository;

    public HorseService(HorseRepository horseRepository, TenantRepository tenantRepository, FeedScheduleRepository feedScheduleRepository) {
        this.horseRepository = horseRepository;
        this.tenantRepository = tenantRepository;
        this.feedScheduleRepository = feedScheduleRepository;
    }

    public List<HorseDto> getAllHorses() {
        return horseRepository.findAll()
                .stream()
                .map(HorseDto::getDto)
                .collect(Collectors.toList());
    }

    public HorseDto getHorseById(Long id) {
        return horseRepository.findById(id)
                .map(HorseDto::getDto)
                .orElse(null);
    }

    public HorseDto createHorse(HorseDto horseDto) {
        Horse horse = new Horse();
        horse.setName(horseDto.name());
        TenantDto.getDto(horse.getTenant());
        horseRepository.save(horse);
        return HorseDto.getDto(horse);
    }

    public HorseDto assignHorseToTenant(Long tenantId, Long horseId) {
        if (horseRepository.findById(horseId).isEmpty() || tenantRepository.findById(tenantId).isEmpty()) {
            throw new NoSuchElementException("Horse or Stall not found");
        }
        Tenant tenant = tenantRepository.findById(tenantId).get();
        Horse horse = horseRepository.findById(horseId).get();
        horse.assignTenant(tenant);
        horseRepository.save(horse);
        return HorseDto.getDto(horse);
    }

    public HorseDto assignFeedScheduleToHorse(Long horseId, Long feedScheduleId) {
        if (horseRepository.findById(horseId).isEmpty() || feedScheduleRepository.findById(feedScheduleId).isEmpty()) {
            throw new NoSuchElementException("Horse or Feed Schedule not found");
        }
        Horse horse = horseRepository.findById(horseId).get();
        FeedSchedule feedSchedule = feedScheduleRepository.findById(feedScheduleId).get();
        horse.assignFeedSchedule(feedSchedule);
        horseRepository.save(horse);
        return HorseDto.getDto(horse);
    }
}
