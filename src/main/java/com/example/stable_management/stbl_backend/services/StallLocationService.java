package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.stall_location_dto.StallLocationDto;
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

    public List<StallLocationDto> getAllStallLocations() {
        List<StallLocation> stallLocations = stallLocationRepository.findAll();
        return stallLocations.stream()
                .map(StallLocationDto::getDto)
                .collect(Collectors.toList());
    }

    public StallLocationDto getStallLocationById(Long id) {
        return stallLocationRepository.findById(id)
                .map(StallLocationDto::getDto)
                .orElse(null);
    }

    public StallLocationDto createStallLocation(StallLocationDto stallLocationDto) {
        StallLocation stallLocation = new StallLocation();
        stallLocation.setName(stallLocationDto.name());
        stallLocationRepository.save(stallLocation);
        return StallLocationDto.getDto(stallLocation);
    }
}
