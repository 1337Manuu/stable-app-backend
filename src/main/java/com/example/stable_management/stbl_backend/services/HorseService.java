package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dto.HorseRequestDto;
import com.example.stable_management.stbl_backend.entities.Horse;
import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.repositories.HorseRepository;
import com.example.stable_management.stbl_backend.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorseService {

    private final HorseRepository horseRepository;
    private final TenantRepository tenantRepository;

    @Autowired
    public HorseService(HorseRepository horseRepository, TenantRepository tenantRepository) {
        this.horseRepository = horseRepository;
        this.tenantRepository = tenantRepository;
    }

    public List<HorseRequestDto> getAllHorses() {
        return horseRepository.findAll()
                .stream()
                .map(horse -> new HorseRequestDto(
                        horse.getName(),
                        horse.getTenant()
                )).collect(Collectors.toList());
    }

    public HorseRequestDto getHorseById(Long id) {
        return horseRepository.findById(id)
                .map(horse -> new HorseRequestDto(
                        horse.getName(),
                        horse.getTenant()
                ))
                .orElse(null);
    }

    public Horse createHorse(Horse horse) {
        return horseRepository.save(horse);
    }

    public Horse assignTenantToHorse(Long tenantId, Long horseId) {
        Tenant tenant = tenantRepository.findById(tenantId).get();
        Horse horse = horseRepository.findById(horseId).get();
        horse.assignTenant(tenant);
        return horseRepository.save(horse);
    }
}
