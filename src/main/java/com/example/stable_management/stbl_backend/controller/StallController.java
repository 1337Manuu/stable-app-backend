package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dto.StallRequestDto;
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
    public List<StallRequestDto> getAllStall(){
        return stallService.getAllStalls();
    }

    @GetMapping("/{id}")
    public StallRequestDto getStallById(@PathVariable Long id) {
        return stallService.getStallById(id);
    }

    @PostMapping
    public Stall createStall(@RequestBody Stall stall) {
        return stallService.createStall(stall);
    }
}
