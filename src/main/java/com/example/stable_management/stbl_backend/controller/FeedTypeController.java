package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.FeedTypeDto;
import com.example.stable_management.stbl_backend.entities.FeedType;
import com.example.stable_management.stbl_backend.services.interfaces.FeedTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed-types")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedTypeController {

    private final FeedTypeService feedTypeService;

    public FeedTypeController(FeedTypeService feedTypeService) {
        this.feedTypeService = feedTypeService;
    }

    @GetMapping
    public ResponseEntity<List<FeedType>> getAllFeedTypes() {
        return new ResponseEntity<>(feedTypeService.getAllFeedTypes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedType> getFeedTypeById(@PathVariable Long id) {
        return new ResponseEntity<>(feedTypeService.getFeedTypeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedType> createFeedType(@RequestBody FeedTypeDto feedTypeDto) {
        return new ResponseEntity<>(feedTypeService.createFeedType(feedTypeDto), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFeedType(@PathVariable Long id) {
        feedTypeService.deleteFeedTypeById(id);
        return new ResponseEntity<>("FeedType deleted.", HttpStatus.OK);
    }
}