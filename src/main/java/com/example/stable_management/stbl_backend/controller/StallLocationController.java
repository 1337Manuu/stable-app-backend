package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.entities.StallLocation;
import com.example.stable_management.stbl_backend.services.StallLocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stall-locations")
public class StallLocationController {

    private final StallLocationService stallLocationService;

    public StallLocationController(StallLocationService stallLocationService) {
        this.stallLocationService = stallLocationService;
    }


    @GetMapping
    public ResponseEntity<List<StallLocation>> getAllStallLocations() {
        return new ResponseEntity<>(stallLocationService.getAllStallLocations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StallLocation> getStallLocationById(@PathVariable long id) {
        return new ResponseEntity<>(stallLocationService.getStallLocationById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StallLocation> createStallLocation(@RequestBody StallLocation stallLocation) {
        return new ResponseEntity<>(stallLocationService.createStallLocation(stallLocation), HttpStatus.CREATED);
    }

}
