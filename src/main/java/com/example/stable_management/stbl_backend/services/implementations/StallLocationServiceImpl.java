package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.dtos.StallDto;
import com.example.stable_management.stbl_backend.dtos.StallLocationDto;
import com.example.stable_management.stbl_backend.entities.Stall;
import com.example.stable_management.stbl_backend.entities.StallLocation;
import com.example.stable_management.stbl_backend.repositories.StallLocationRepository;
import com.example.stable_management.stbl_backend.services.interfaces.StallLocationService;
import com.example.stable_management.stbl_backend.services.interfaces.StallService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StallLocationServiceImpl implements StallLocationService {

    StallLocationRepository stallLocationRepository;
    StallService stallService;

    public StallLocationServiceImpl(StallLocationRepository stallLocationRepository, StallService stallService) {
        this.stallLocationRepository = stallLocationRepository;
        this.stallService = stallService;
    }

    @Override
    public List<StallLocation> getAllStallLocations() {
        return stallLocationRepository.findAll();
    }

    @Override
    public StallLocation getStallLocationById(Long id) {
        return stallLocationRepository.findById(id).orElse(null);
    }

    @Override
    public StallLocation createStallLocation(StallLocationDto stallLocationDto) {
        StallLocation newStallLocation = new StallLocation();
        stallLocationRepository.save(newStallLocation);
        newStallLocation.setName(stallLocationDto.name());
        for (int boxNumber = 1; boxNumber < stallLocationDto.amountStalls() + 1; boxNumber++) {
            Stall newStall = stallService.createStall(new StallDto(boxNumber, newStallLocation.getId()));
            newStallLocation.addStall(newStall);
        }
        return stallLocationRepository.save(newStallLocation);
    }
}
