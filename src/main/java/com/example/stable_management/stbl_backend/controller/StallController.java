package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.StallDto;
import com.example.stable_management.stbl_backend.entities.Stall;
import com.example.stable_management.stbl_backend.services.interfaces.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stalls")
@CrossOrigin(origins = "http://localhost:3000")
public class StallController {

    private final StallService stallService;

    @Autowired
    public StallController(StallService stallService) {
        this.stallService = stallService;
    }

    @GetMapping
    public ResponseEntity<List<Stall>> getAllStall() {
        return new ResponseEntity<>(stallService.getAllStalls(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stall> getStallById(@PathVariable Long id) {

        return new ResponseEntity<>(stallService.getStallById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Stall> createStall(@RequestBody StallDto stallDto) {
        return new ResponseEntity<>(stallService.createStall(stallDto), HttpStatus.CREATED);
    }

    @PutMapping("/{stallId}/horses/{horseId}")
    public ResponseEntity<Stall> assignHorseToStall(@PathVariable Long horseId, @PathVariable Long stallId) {
        return new ResponseEntity<>(stallService.assignHorseToStall(horseId, stallId), HttpStatus.OK);
    }

    @PutMapping("/{stallId}/stall-locations/{stallLocationId}")
    public ResponseEntity<Stall> assignStallToLocation(@PathVariable Long stallId, @PathVariable Long stallLocationId) {
        return new ResponseEntity<>(stallService.assignStallToStallLocation(stallId, stallLocationId), HttpStatus.OK);
    }
}
