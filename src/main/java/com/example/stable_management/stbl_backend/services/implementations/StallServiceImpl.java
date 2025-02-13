package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.dtos.StallDto;
import com.example.stable_management.stbl_backend.entities.Horse;
import com.example.stable_management.stbl_backend.entities.Stall;
import com.example.stable_management.stbl_backend.entities.StallLocation;
import com.example.stable_management.stbl_backend.exceptions.ResourceNotFoundException;
import com.example.stable_management.stbl_backend.repositories.StallRepository;
import com.example.stable_management.stbl_backend.services.interfaces.HorseService;
import com.example.stable_management.stbl_backend.services.interfaces.StallLocationService;
import com.example.stable_management.stbl_backend.services.interfaces.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StallServiceImpl implements StallService {

    private final StallRepository stallRepository;
    private final StallLocationService stallLocationService;
    private final HorseService horseService;

    @Autowired
    public StallServiceImpl(StallRepository stallRepository, @Lazy StallLocationService stallLocationService, @Lazy HorseService horseService) {
        this.stallRepository = stallRepository;
        this.stallLocationService = stallLocationService;
        this.horseService = horseService;
    }

    @Override
    public List<Stall> getAllStalls() {
        return stallRepository.findAll();
    }

    @Override
    public Stall getStallById(Long id) {
        return stallRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No stall found with id " + id));
    }

    @Override
    public Stall createStall(StallDto stallDto) {
        StallLocation stallLocation = stallLocationService.getStallLocationById(stallDto.stallLocationId());

        Stall newStall = new Stall();
        newStall.setStallNumber(stallDto.stallNumber());
        newStall.assignStallLocation(stallLocation);

        return stallRepository.save(newStall);
    }

    @Override
    public Stall assignHorseToStall(Long horseId, Long stallId){
        Horse horse = horseService.getHorseById(horseId);
        Stall stall = getStallById(stallId);
        stall.assignHorse(horse);
        return stallRepository.save(stall);
    }

    @Override
    public Stall assignStallToStallLocation(Long stallId, Long stallLocationId) {
        Stall stall = getStallById(stallId);
        StallLocation stallLocation = stallLocationService.getStallLocationById(stallLocationId);
        stall.assignStallLocation(stallLocation);
        return stallRepository.save(stall);
    }

}

