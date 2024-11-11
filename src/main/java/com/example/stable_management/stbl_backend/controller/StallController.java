package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.stall_dto.StallDto;
import com.example.stable_management.stbl_backend.entities.Stall;
import com.example.stable_management.stbl_backend.services.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stalls")
public class StallController {

    private final StallService stallService;

    @Autowired
    public StallController(StallService stallService) {
        this.stallService = stallService;
    }

    @GetMapping
    public ResponseEntity<List<StallDto>> getAllStall() {
        List<StallDto> stallDtoList = stallService.getAllStalls();
        return new ResponseEntity<>(stallDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StallDto> getStallById(@PathVariable Long id) {
        StallDto stallDto = stallService.getStallById(id);
        return new ResponseEntity<>(stallDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StallDto> createStall(@RequestBody StallDto stall) {
        StallDto stallDto = stallService.createStall(stall);
        return new ResponseEntity<>(stallDto, HttpStatus.CREATED);
    }

    @PutMapping("/{stallId}/horses/{horseId}")
    public ResponseEntity<StallDto> assignHorseToStall(@PathVariable Long horseId, @PathVariable Long stallId) {
        StallDto stallDto = stallService.assignHorseToStall(horseId, stallId);
        return new ResponseEntity<>(stallDto, HttpStatus.OK);
    }

    @PutMapping("/{stallId}/stall-locations/{stallLocationId}")
    public ResponseEntity<StallDto> assignStallToLocation(@PathVariable Long stallId, @PathVariable Long stallLocationId) {
        StallDto stallDto = stallService.assignStallToStallLocation(stallId, stallLocationId);
        return new ResponseEntity<>(stallDto, HttpStatus.OK);
    }
}
