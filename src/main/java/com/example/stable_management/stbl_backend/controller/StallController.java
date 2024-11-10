package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.stall_dto.StallDto;
import com.example.stable_management.stbl_backend.entities.Stall;
import com.example.stable_management.stbl_backend.services.StallService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<StallDto> getAllStall() {
        return stallService.getAllStalls();
    }

    @GetMapping("/{id}")
    public StallDto getStallById(@PathVariable Long id) {
        return stallService.getStallById(id);
    }

    @PostMapping
    public StallDto createStall(@RequestBody Stall stall) {
        return stallService.createStall(stall);
    }

    @PutMapping("/{stallId}/horses/{horseId}")
    public StallDto assignHorseToStall(@PathVariable Long horseId, @PathVariable Long stallId) {
        return stallService.assignHorseToStall(horseId, stallId);
    }

    @PutMapping("/{stallId}/stall-locations/{stallLocationId}")
    public StallDto assignStallToLocation(@PathVariable Long stallId, @PathVariable Long stallLocationId) {
        return stallService.assignStallToStallLocation(stallId, stallLocationId);
    }
}
