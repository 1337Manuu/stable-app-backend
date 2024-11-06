package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.entities.Horse;
import com.example.stable_management.stbl_backend.repositories.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
public class HorseController {

    @Autowired
    private HorseRepository horseRepository;


    @PostMapping("/horses/create")
    public String createHorse(@RequestBody Horse horse) {
        horseRepository.save(horse);
        return "Horse created...";
    }

    @PutMapping("/horses/update")
    public Horse updateHorse(Horse updatedHorse) {
        return horseRepository.save(updatedHorse);
    }

    @GetMapping("/horses")
    public List<Horse> getAllHorses() {
        return horseRepository.findAll();
    }

    @GetMapping("/horses/{id}")
    public Horse getHorseById(@PathVariable Integer id){
        return horseRepository.findById(id).orElse(null);
    }


}


