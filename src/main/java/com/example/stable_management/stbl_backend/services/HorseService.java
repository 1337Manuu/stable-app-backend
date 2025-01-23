package com.example.stable_management.stbl_backend.services;

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
    private final TenantService tenantService;

    public HorseService(HorseRepository horseRepository, TenantRepository tenantRepository, FeedScheduleRepository feedScheduleRepository, TenantService tenantService) {
        this.horseRepository = horseRepository;
        this.tenantRepository = tenantRepository;
        this.feedScheduleRepository = feedScheduleRepository;
        this.tenantService = tenantService;
    }

    public List<Horse> getAllHorses() {
        return horseRepository.findAll();
    }

    public Horse getHorseById(Long id) {
        return horseRepository.findById(id).orElse(null);
    }

    public Horse createHorse(Horse horse) {
        return horseRepository.save(horse);
    }

    public Horse assignHorseToTenant(Long tenantId, Long horseId) {
        if (horseRepository.findById(horseId).isEmpty() || tenantRepository.findById(tenantId).isEmpty()) {
            throw new NoSuchElementException("Horse or Stall not found");
        }
        Tenant tenant = tenantRepository.findById(tenantId).get();
        Horse horse = horseRepository.findById(horseId).get();
        horse.assignTenant(tenant);
        return horseRepository.save(horse);
    }

    public Horse assignFeedScheduleToHorse(Long horseId, Long feedScheduleId) {
        if (horseRepository.findById(horseId).isEmpty() || feedScheduleRepository.findById(feedScheduleId).isEmpty()) {
            throw new NoSuchElementException("Horse or Feed Schedule not found");
        }
        Horse horse = horseRepository.findById(horseId).get();
        FeedSchedule feedSchedule = feedScheduleRepository.findById(feedScheduleId).get();
        horse.assignFeedSchedule(feedSchedule);
        return horseRepository.save(horse);
    }
}
