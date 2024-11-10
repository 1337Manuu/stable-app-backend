package com.example.stable_management.stbl_backend.controller;


import com.example.stable_management.stbl_backend.dtos.horse_dto.HorseDto;
import com.example.stable_management.stbl_backend.services.HorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<HorseDto>> getAllHorses() {
        List<HorseDto> horseDtoList = horseService.getAllHorses();
        return new ResponseEntity<>(horseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorseDto> getHorseById(@PathVariable Long id) {
        HorseDto horseDto = horseService.getHorseById(id);
        return new ResponseEntity<>(horseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HorseDto> createHorse(@RequestBody HorseDto horseDto) {
        HorseDto createdHorse = horseService.createHorse(horseDto);
        return new ResponseEntity<>(createdHorse, HttpStatus.CREATED);
    }

    @PutMapping("/{horseId}/tenants/{tenantId}")
    public ResponseEntity<HorseDto> assignHorseToTenant(@PathVariable Long tenantId, @PathVariable Long horseId) {
        HorseDto assignedHorse = horseService.assignHorseToTenant(tenantId, horseId);
        return new ResponseEntity<>(assignedHorse, HttpStatus.OK);
    }


    //TODO: fix FeedSchedule to Horse assignment.
    @PutMapping("/{horseId}/feed-schedules/{feedScheduleId}")
    public ResponseEntity<HorseDto> assignFeedScheduleToHorse(@PathVariable Long horseId, @PathVariable Long feedScheduleId) {
        HorseDto updatedHorse = horseService.assignFeedScheduleToHorse(horseId, feedScheduleId);
        return new ResponseEntity<>(updatedHorse, HttpStatus.OK);
    }
}