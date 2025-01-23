package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import com.example.stable_management.stbl_backend.repositories.FeedScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedScheduleService {

    private final FeedScheduleRepository feedScheduleRepository;

    public FeedScheduleService(FeedScheduleRepository feedScheduleRepository) {
        this.feedScheduleRepository = feedScheduleRepository;
    }

    public List<FeedSchedule> getAllFeedSchedules() {
        return feedScheduleRepository.findAll();
    }

    public FeedSchedule getFeedScheduleById(Long id) {
        return feedScheduleRepository.findById(id).orElse(null);
    }

    public FeedSchedule createFeedSchedule(FeedSchedule feedSchedule) {
        return feedScheduleRepository.save(feedSchedule);
    }


}
