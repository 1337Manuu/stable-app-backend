package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.feed_time_dto.FeedTimeDto;
import com.example.stable_management.stbl_backend.services.FeedTimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed-time")
public class FeedTimeController {

    private final FeedTimeService feedTimeService;

    public FeedTimeController(FeedTimeService feedTimeService) {
        this.feedTimeService = feedTimeService;
    }

    @GetMapping
    public ResponseEntity<List<FeedTimeDto>> getAllFeedTimes() {
        List<FeedTimeDto> feedTimeDtoList = feedTimeService.getAllFeedTimes();
        return new ResponseEntity<>(feedTimeDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedTimeDto> getFeedTimeById(@PathVariable Long id) {
        FeedTimeDto feedTimeDto = feedTimeService.getFeedTimeById(id);
        return new ResponseEntity<>(feedTimeDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedTimeDto> createFeedTime(@RequestBody FeedTimeDto feedTimeDto) {
        FeedTimeDto createdFeedTimeDto = feedTimeService.createFeedTime(feedTimeDto);
        return new ResponseEntity<>(createdFeedTimeDto, HttpStatus.CREATED);
    }
}
