package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import com.example.stable_management.stbl_backend.repositories.FeedScheduleRepository;
import com.example.stable_management.stbl_backend.services.interfaces.FeedScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedScheduleServiceImpl implements FeedScheduleService {

    private final FeedScheduleRepository feedScheduleRepository;

    public FeedScheduleServiceImpl(FeedScheduleRepository feedScheduleRepository) {
        this.feedScheduleRepository = feedScheduleRepository;
    }

    @Override
    public List<FeedSchedule> getAllFeedSchedules() {
        return feedScheduleRepository.findAll();
    }

    @Override
    public FeedSchedule getFeedScheduleById(Long id) {
        return feedScheduleRepository.findById(id).orElse(null);
    }

    @Override
    public FeedSchedule createFeedSchedule(FeedSchedule feedSchedule) {
        return feedScheduleRepository.save(feedSchedule);
    }


}
