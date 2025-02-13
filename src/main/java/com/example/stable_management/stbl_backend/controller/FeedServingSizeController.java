package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.FeedServingSizeDto;
import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.services.interfaces.FeedServingSizeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed-serving-sizes")
public class FeedServingSizeController {

    private final FeedServingSizeService feedServingSizeService;

    public FeedServingSizeController(FeedServingSizeService feedServingSizeService) {
        this.feedServingSizeService = feedServingSizeService;
    }

    @GetMapping
    public ResponseEntity<List<FeedServingSize>> getAllFeedServingSizes() {
        return new ResponseEntity<>(feedServingSizeService.getAllFeedServingSizes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedServingSize> getFeedServingSizeById(@PathVariable Long id) {
        return new ResponseEntity<>(feedServingSizeService.getFeedServingSizeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedServingSize> createFeedServingSize(@RequestBody FeedServingSizeDto feedServingSizeDto) {
        return new ResponseEntity<>(feedServingSizeService.createFeedServingSize(feedServingSizeDto), HttpStatus.CREATED);
    }
}