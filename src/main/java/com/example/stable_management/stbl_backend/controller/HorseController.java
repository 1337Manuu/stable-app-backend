package com.example.stable_management.stbl_backend.controller;


import com.example.stable_management.stbl_backend.dto.HorseRequestDto;
import com.example.stable_management.stbl_backend.entities.Horse;
import com.example.stable_management.stbl_backend.entities.Tenant;
import com.example.stable_management.stbl_backend.services.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horses")
public class HorseController {

    private final HorseService horseService;

    @Autowired
    public HorseController(HorseService horseService) {
        this.horseService = horseService;
    }

    @GetMapping
    public List<HorseRequestDto> getAllHorses() {
        return horseService.getAllHorses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorseRequestDto> getHorseById(@PathVariable Long id) {
        return ResponseEntity.ok(horseService.getHorseById(id));
    }

    @PostMapping
    public Horse createHorse(@RequestBody Horse horse) {
        return horseService.createHorse(horse);
    }

    @PutMapping("/{horseId}/tenants/{tenantId}")
    public Horse assignHorseToTenant(@PathVariable Long tenantId, @PathVariable Long horseId) {
        return horseService.assignTenantToHorse(tenantId, horseId);
    }
}


