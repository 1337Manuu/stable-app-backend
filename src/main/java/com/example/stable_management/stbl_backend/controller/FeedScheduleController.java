package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import com.example.stable_management.stbl_backend.services.FeedScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed-schedules")
public class FeedScheduleController {

    private final FeedScheduleService feedScheduleService;

    public FeedScheduleController(FeedScheduleService feedScheduleService) {
        this.feedScheduleService = feedScheduleService;
    }

    @GetMapping
    public ResponseEntity<List<FeedSchedule>> getFeedSchedule() {
        return new ResponseEntity<>(feedScheduleService.getAllFeedSchedules(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedSchedule> getFeedScheduleById(@PathVariable long id) {
        return new ResponseEntity<>(feedScheduleService.getFeedScheduleById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedSchedule> createFeedSchedule(@RequestBody FeedSchedule feedSchedule) {
        return new ResponseEntity<>(feedScheduleService.createFeedSchedule(feedSchedule), HttpStatus.CREATED);
    }
}
