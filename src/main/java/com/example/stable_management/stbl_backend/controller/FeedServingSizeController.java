package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.feed_serving_size_dto.FeedServingSizeDto;
import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.repositories.FeedServingSizeRepository;
import com.example.stable_management.stbl_backend.services.FeedServingSizeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/feed-serving-sizes")
public class FeedServingSizeController {

    private final FeedServingSizeService feedServingSizeService;

    public FeedServingSizeController(FeedServingSizeService feedServingSizeService) {
        this.feedServingSizeService = feedServingSizeService;
    }

    @GetMapping
    public ResponseEntity<List<FeedServingSizeDto>> getAllFeedServingSizes() {
        List<FeedServingSizeDto> feedServingSizeDtoList = feedServingSizeService.getAllFeedServingSizes();
        return new ResponseEntity<>(feedServingSizeDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedServingSizeDto> getFeedServingSizeById(@PathVariable Long id) {
        FeedServingSizeDto feedServingSizeDto = feedServingSizeService.getFeedServingSizeById(id);
        return new ResponseEntity<>(feedServingSizeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedServingSizeDto> createFeedServingSize(@RequestBody FeedServingSizeDto feedServingSizeDto) {
        FeedServingSizeDto createdFeedServingSizeDto = feedServingSizeService.createFeedServingSize(feedServingSizeDto);
        return new ResponseEntity<>(createdFeedServingSizeDto, HttpStatus.CREATED);
    }
}