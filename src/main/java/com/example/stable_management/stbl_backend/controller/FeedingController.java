package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.FeedingDto;
import com.example.stable_management.stbl_backend.entities.Feeding;
import com.example.stable_management.stbl_backend.services.interfaces.FeedingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedings")
@CrossOrigin(origins = "http://localhost:3000")
public class FeedingController {

    private final FeedingService feedingService;

    public FeedingController(FeedingService feedingService) {
        this.feedingService = feedingService;
    }

    @GetMapping
    public ResponseEntity<List<Feeding>> getAllFeedTimes() {
        return new ResponseEntity<>(feedingService.getAllFeedTimes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feeding> getFeedTimeById(@PathVariable Long id) {
        return new ResponseEntity<>(feedingService.getFeedTimeById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Feeding> createFeedTime(@RequestBody FeedingDto feedingDto) {
        return new ResponseEntity<>(feedingService.createFeeding(feedingDto), HttpStatus.CREATED);
    }

    @PutMapping("/{feedingId}/feed-serving-sizes/{feedServingSizeId}")
    public ResponseEntity<Feeding> assignFeedServingSizeToFeedTime(
            @PathVariable Long feedingId,
            @PathVariable Long feedServingSizeId) {
        return new ResponseEntity<>(
                feedingService.assignFeedServingSizeToFeedTime(feedingId, feedServingSizeId),
                HttpStatus.OK);
    }

    @PutMapping("/{feedingId}/feed-types/{feedTypeId}")
    public ResponseEntity<Feeding> assignFeedTypeToFeedTime(@PathVariable Long feedingId, @PathVariable Long feedTypeId) {
        return new ResponseEntity<>(feedingService.assignFeedTypeToFeedTime(feedingId, feedTypeId), HttpStatus.OK);
    }

    @PutMapping("/{feedingId}/feed-schedules/{feedScheduleId}")
    public ResponseEntity<Feeding> assignFeedScheduleToFeedTime(@PathVariable Long feedingId, @PathVariable Long feedScheduleId) {
        return new ResponseEntity<>(feedingService.assignFeedScheduleToFeedTime(feedingId, feedScheduleId), HttpStatus.OK);
    }
}
