package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.HorseDto;
import com.example.stable_management.stbl_backend.entities.Horse;
import com.example.stable_management.stbl_backend.services.interfaces.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/horses")
public class HorseController {

    private final HorseService horseService;

    @Autowired
    public HorseController(HorseService horseService) {
        this.horseService = horseService;
    }

    @GetMapping
    public ResponseEntity<List<Horse>> getAllHorses() {
        return new ResponseEntity<>(horseService.getAllHorses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horse> getHorseById(@PathVariable Long id) {
        return new ResponseEntity<>(horseService.getHorseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Horse> createHorse(@RequestBody HorseDto horseDto) {
        horseService.validate(horseDto);
        return new ResponseEntity<>(horseService.createHorse(horseDto), HttpStatus.CREATED);
    }

    @PutMapping("/{horseId}/tenants/{tenantId}")
    public ResponseEntity<Horse> assignHorseToTenant(@PathVariable Long tenantId, @PathVariable Long horseId) {
        return new ResponseEntity<>(horseService.assignHorseToTenant(tenantId, horseId), HttpStatus.OK);
    }

    @PutMapping("/{horseId}/feed-schedules/{feedScheduleId}")
    public ResponseEntity<Horse> assignFeedScheduleToHorse(@PathVariable Long horseId, @PathVariable Long feedScheduleId) {
        return new ResponseEntity<>(horseService.assignFeedScheduleToHorse(horseId, feedScheduleId), HttpStatus.OK);
    }
}