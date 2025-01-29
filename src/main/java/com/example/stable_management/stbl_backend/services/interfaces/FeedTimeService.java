package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.entities.FeedTime;

import java.util.List;

public interface FeedTimeService {
    List<FeedTime> getAllFeedTimes();

    FeedTime getFeedTimeById(Long id);

    FeedTime createFeedTime(FeedTime feedTime);

    FeedTime assignFeedServingSizeToFeedTime(Long feedTimeId, Long feedServingSizeId);

    FeedTime assignFeedTypeToFeedTime(Long feedTimeId, Long feedTypeId);

    FeedTime assignFeedScheduleToFeedTime(Long feedTimeId, Long feedScheduleId);
}
