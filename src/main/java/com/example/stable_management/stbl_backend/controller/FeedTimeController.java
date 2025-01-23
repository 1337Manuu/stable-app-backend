package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.entities.FeedTime;
import com.example.stable_management.stbl_backend.services.FeedTimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed-times")
public class FeedTimeController {

    private final FeedTimeService feedTimeService;

    public FeedTimeController(FeedTimeService feedTimeService) {
        this.feedTimeService = feedTimeService;
    }

    @GetMapping
    public ResponseEntity<List<FeedTime>> getAllFeedTimes() {
        return new ResponseEntity<>(feedTimeService.getAllFeedTimes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedTime> getFeedTimeById(@PathVariable Long id) {
        return new ResponseEntity<>(feedTimeService.getFeedTimeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedTime> createFeedTime(@RequestBody FeedTime feedTime) {
        return new ResponseEntity<>(feedTimeService.createFeedTime(feedTime), HttpStatus.CREATED);
    }

    @PutMapping("/{feedTimeId}/feed-serving-sizes/{feedServingSizeId}")
    public ResponseEntity<FeedTime> assignFeedServingSizeToFeedTime(
            @PathVariable Long feedTimeId,
            @PathVariable Long feedServingSizeId) {
        return new ResponseEntity<>(
                feedTimeService.assignFeedServingSizeToFeedTime(feedTimeId, feedServingSizeId),
                HttpStatus.OK);
    }

    @PutMapping("/{feedTimeId}/feed-types/{feedTypeId}")
    public ResponseEntity<FeedTime> assignFeedTypeToFeedTime(@PathVariable Long feedTimeId, @PathVariable Long feedTypeId) {
        return new ResponseEntity<>(feedTimeService.assignFeedTypeToFeedTime(feedTimeId, feedTypeId), HttpStatus.OK);
    }

    @PutMapping("/{feedTimeId}/feed-schedules/{feedScheduleId}")
    public ResponseEntity<FeedTime> assignFeedScheduleToFeedTime(@PathVariable Long feedTimeId, @PathVariable Long feedScheduleId) {
        return new ResponseEntity<>(feedTimeService.assignFeedScheduleToFeedTime(feedTimeId, feedScheduleId), HttpStatus.OK);
    }
}
