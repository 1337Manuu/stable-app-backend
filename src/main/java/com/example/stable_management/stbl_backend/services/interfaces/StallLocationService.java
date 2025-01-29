package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.entities.StallLocation;

import java.util.List;

public interface StallLocationService {
    List<StallLocation> getAllStallLocations();

    StallLocation getStallLocationById(Long id);

    StallLocation createStallLocation(StallLocation stallLocation);
}
