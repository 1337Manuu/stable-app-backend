package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.horse_dto.HorseDto;
import com.example.stable_management.stbl_backend.dtos.stall_dto.StallDto;
import com.example.stable_management.stbl_backend.dtos.horse_dto.HorseDtoForStallRequest;
import com.example.stable_management.stbl_backend.entities.Horse;
import com.example.stable_management.stbl_backend.entities.Stall;
import com.example.stable_management.stbl_backend.entities.StallLocation;
import com.example.stable_management.stbl_backend.repositories.HorseRepository;
import com.example.stable_management.stbl_backend.repositories.StallLocationRepository;
import com.example.stable_management.stbl_backend.repositories.StallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class StallService {

    private final StallRepository stallRepository;
    private final HorseRepository horseRepository;
    private final StallLocationRepository stallLocationRepository;

    @Autowired
    public StallService(StallRepository stallRepository, HorseRepository horseRepository, StallLocationRepository stallLocationRepository) {
        this.stallRepository = stallRepository;
        this.horseRepository = horseRepository;
        this.stallLocationRepository = stallLocationRepository;
    }

    public List<StallDto> getAllStalls() {
        return stallRepository.findAll()
                .stream()
                .map(StallDto::getDto)
                .collect(Collectors.toList());
    }

    public StallDto getStallById(Long id) {
        return stallRepository.findById(id)
                .map(StallDto::getDto)
                .orElse(null);
    }

    public StallDto createStall(StallDto stallDto) {
        Stall stall = new Stall();
        stall.setName(stallDto.name());
        stallRepository.save(stall);
        return StallDto.getDto(stall);
    }

    public StallDto assignHorseToStall(Long horseId, Long stallId){
        if (horseRepository.findById(horseId).isEmpty() || stallRepository.findById(stallId).isEmpty()) {
            throw new NoSuchElementException("Horse or Stall not found");
        }
        Horse horse = horseRepository.findById(horseId).get();
        Stall stall = stallRepository.findById(stallId).get();
        stall.assignHorse(horse);
        stallRepository.save(stall);
        return StallDto.getDto(stall);
    }

    public StallDto assignStallToStallLocation(Long stallId, Long stallLocationId) {
        if (stallRepository.findById(stallId).isEmpty() || stallLocationRepository.findById(stallLocationId).isEmpty()) {
            throw new NoSuchElementException("Stall or Stall Location not found");
        }
        Stall stall = stallRepository.findById(stallId).get();
        StallLocation stallLocation = stallLocationRepository.findById(stallLocationId).get();
        stall.assignStallLocation(stallLocation);
        return StallDto.getDto(stallRepository.save(stall));
    }
}

