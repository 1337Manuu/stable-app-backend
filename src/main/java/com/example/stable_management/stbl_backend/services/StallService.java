package com.example.stable_management.stbl_backend.services;

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

    public List<Stall> getAllStalls() {
        return stallRepository.findAll();
    }

    public Stall getStallById(Long id) {
        return stallRepository.findById(id).orElse(null);
    }

    public Stall createStall(Stall stall) {
        return stallRepository.save(stall);
    }

    public Stall assignHorseToStall(Long horseId, Long stallId){
        if (horseRepository.findById(horseId).isEmpty() || stallRepository.findById(stallId).isEmpty()) {
            throw new NoSuchElementException("Horse or Stall not found");
        }
        Horse horse = horseRepository.findById(horseId).get();
        Stall stall = stallRepository.findById(stallId).get();
        stall.assignHorse(horse);
        return stallRepository.save(stall);
    }

    public Stall assignStallToStallLocation(Long stallId, Long stallLocationId) {
        if (stallRepository.findById(stallId).isEmpty() || stallLocationRepository.findById(stallLocationId).isEmpty()) {
            throw new NoSuchElementException("Stall or Stall Location not found");
        }
        Stall stall = stallRepository.findById(stallId).get();
        StallLocation stallLocation = stallLocationRepository.findById(stallLocationId).get();
        stall.assignStallLocation(stallLocation);
        return stallRepository.save(stall);
    }
}

