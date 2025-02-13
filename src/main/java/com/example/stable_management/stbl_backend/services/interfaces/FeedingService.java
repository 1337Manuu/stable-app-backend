package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.dtos.FeedingDto;
import com.example.stable_management.stbl_backend.entities.Feeding;

import java.util.List;

public interface FeedingService {
    List<Feeding> getAllFeedTimes();

    Feeding getFeedTimeById(Long id);

    Feeding createFeeding(FeedingDto feedingDto);

    Feeding assignFeedServingSizeToFeedTime(Long feedTimeId, Long feedServingSizeId);

    Feeding assignFeedTypeToFeedTime(Long feedTimeId, Long feedTypeId);

    Feeding assignFeedScheduleToFeedTime(Long feedTimeId, Long feedScheduleId);
}
