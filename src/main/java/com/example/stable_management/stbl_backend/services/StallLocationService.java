package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.entities.StallLocation;
import com.example.stable_management.stbl_backend.repositories.StallLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StallLocationService {

    StallLocationRepository stallLocationRepository;

    public StallLocationService(StallLocationRepository stallLocationRepository) {
        this.stallLocationRepository = stallLocationRepository;
    }

    public List<StallLocation> getAllStallLocations() {
        return stallLocationRepository.findAll();
    }

    public StallLocation getStallLocationById(Long id) {
        return stallLocationRepository.findById(id).orElse(null);
    }

    public StallLocation createStallLocation(StallLocation stallLocation) {
        return stallLocationRepository.save(stallLocation);
    }
}
