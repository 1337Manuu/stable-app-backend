package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.entities.FeedSchedule;

import java.util.List;

public interface FeedScheduleService {
    List<FeedSchedule> getAllFeedSchedules();

    FeedSchedule getFeedScheduleById(Long id);

    FeedSchedule createFeedSchedule(FeedSchedule feedSchedule);
}
