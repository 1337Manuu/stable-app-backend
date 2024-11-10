package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.stall_location_dto.StallLocationDto;
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
    public ResponseEntity<List<StallLocationDto>> getAllStallLocations() {
        List<StallLocationDto> stallLocationDtoList = stallLocationService.getAllStallLocations();
        return new ResponseEntity<>(stallLocationDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StallLocationDto> getStallLocationById(@PathVariable long id) {
        StallLocationDto stallLocationDto = stallLocationService.getStallLocationById(id);
        return new ResponseEntity<>(stallLocationDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StallLocationDto> createStallLocation(@RequestBody StallLocationDto stallLocationDto) {
        StallLocationDto createdStallLocationDto = stallLocationService.createStallLocation(stallLocationDto);
        return new ResponseEntity<>(createdStallLocationDto, HttpStatus.CREATED);
    }

}
