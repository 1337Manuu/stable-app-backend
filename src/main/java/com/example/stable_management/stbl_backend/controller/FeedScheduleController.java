package com.example.stable_management.stbl_backend.controller;

import com.example.stable_management.stbl_backend.dtos.feed_schedule_dto.FeedScheduleDto;
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
    public ResponseEntity<List<FeedScheduleDto>> getFeedSchedule() {
        List<FeedScheduleDto> feedScheduleDtoList = feedScheduleService.getAllFeedSchedules();
        return new ResponseEntity<>(feedScheduleDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedScheduleDto> getFeedScheduleById(@PathVariable long id) {
        FeedScheduleDto feedScheduleDto = feedScheduleService.getFeedScheduleById(id);
        return new ResponseEntity<>(feedScheduleDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedScheduleDto> createFeedSchedule(@RequestBody FeedScheduleDto feedScheduleDto) {
        FeedScheduleDto createdFeedScheduleDto = feedScheduleService.createFeedSchedule(feedScheduleDto);
        return new ResponseEntity<>(createdFeedScheduleDto, HttpStatus.CREATED);
    }
}
