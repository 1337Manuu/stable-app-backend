package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.entities.StallLocation;
import com.example.stable_management.stbl_backend.repositories.StallLocationRepository;
import com.example.stable_management.stbl_backend.services.interfaces.StallLocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StallLocationServiceImpl implements StallLocationService {

    StallLocationRepository stallLocationRepository;

    public StallLocationServiceImpl(StallLocationRepository stallLocationRepository) {
        this.stallLocationRepository = stallLocationRepository;
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
    public StallLocation createStallLocation(StallLocation stallLocation) {
        return stallLocationRepository.save(stallLocation);
    }
}
