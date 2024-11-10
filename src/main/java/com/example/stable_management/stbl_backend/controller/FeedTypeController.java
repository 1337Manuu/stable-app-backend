package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.feed_type_dto.FeedTypeDto;
import com.example.stable_management.stbl_backend.services.FeedTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed-type")
public class FeedTypeController {

    private final FeedTypeService feedTypeService;

    public FeedTypeController(FeedTypeService feedTypeService) {
        this.feedTypeService = feedTypeService;
    }

    @GetMapping
    public ResponseEntity<List<FeedTypeDto>> getAllFeedTypes() {
        List<FeedTypeDto> feedTypeDtoList = feedTypeService.getAllFeedTypes();
        return new ResponseEntity<>(feedTypeDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedTypeDto> getFeedTypeById(@PathVariable Long id) {
        FeedTypeDto feedTypeDto = feedTypeService.getFeedTypeById(id);
        return new ResponseEntity<>(feedTypeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedTypeDto> createFeedType(FeedTypeDto feedTypeDto) {
        FeedTypeDto createdFeedTypeDto = feedTypeService.createFeedType(feedTypeDto);
        return new ResponseEntity<>(createdFeedTypeDto, HttpStatus.CREATED);
    }
}
