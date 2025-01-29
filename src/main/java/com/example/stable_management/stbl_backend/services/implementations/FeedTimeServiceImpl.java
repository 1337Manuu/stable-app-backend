package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.entities.FeedTime;
import com.example.stable_management.stbl_backend.entities.FeedType;
import com.example.stable_management.stbl_backend.repositories.FeedScheduleRepository;
import com.example.stable_management.stbl_backend.repositories.FeedServingSizeRepository;
import com.example.stable_management.stbl_backend.repositories.FeedTimeRepository;
import com.example.stable_management.stbl_backend.repositories.FeedTypeRepository;
import com.example.stable_management.stbl_backend.services.interfaces.FeedTimeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FeedTimeServiceImpl implements FeedTimeService {

    private final FeedTimeRepository feedTimeRepository;
    private final FeedServingSizeRepository feedServingSizeRepository;
    private final FeedTypeRepository feedTypeRepository;
    private final FeedScheduleRepository feedScheduleRepository;

    public FeedTimeServiceImpl(FeedTimeRepository feedTimeRepository, FeedServingSizeRepository feedServingSizeRepository, FeedTypeRepository feedTypeRepository, FeedScheduleRepository feedScheduleRepository) {
        this.feedTimeRepository = feedTimeRepository;
        this.feedServingSizeRepository = feedServingSizeRepository;
        this.feedTypeRepository = feedTypeRepository;
        this.feedScheduleRepository = feedScheduleRepository;
    }

    @Override
    public List<FeedTime> getAllFeedTimes() {
        return feedTimeRepository.findAll();
    }

    @Override
    public FeedTime getFeedTimeById(Long id) {
        return feedTimeRepository.findById(id).orElse(null);
    }

    @Override
    public FeedTime createFeedTime(FeedTime feedTime) {
        return feedTimeRepository.save(feedTime);
    }

    @Override
    public FeedTime assignFeedServingSizeToFeedTime(Long feedTimeId, Long feedServingSizeId) {
        if (feedTimeRepository.findById(feedTimeId).isEmpty() || feedServingSizeRepository.findById(feedServingSizeId).isEmpty()) {
            throw new NoSuchElementException("Feed Time or Feed Serving Size not found");
        };
        FeedTime feedTime = feedTimeRepository.findById(feedTimeId).get();
        FeedServingSize feedServingSize = feedServingSizeRepository.findById(feedServingSizeId).get();
        feedTime.assignFeedServingSize(feedServingSize);
         return feedTimeRepository.save(feedTime);
    }

    @Override
    public FeedTime assignFeedTypeToFeedTime(Long feedTimeId, Long feedTypeId) {
        if (feedTimeRepository.findById(feedTimeId).isEmpty() || feedTypeRepository.findById(feedTypeId).isEmpty()) {
            throw new NoSuchElementException("Feed Time or Feed Type not found");
        }
        FeedTime feedTime = feedTimeRepository.findById(feedTimeId).get();
        FeedType feedType = feedTypeRepository.findById(feedTypeId).get();
        feedTime.assignFeedType(feedType);
        return feedTimeRepository.save(feedTime);
    }

    @Override
    public FeedTime assignFeedScheduleToFeedTime(Long feedTimeId, Long feedScheduleId) {
        if (feedTimeRepository.findById(feedTimeId).isEmpty() || feedScheduleRepository.findById(feedScheduleId).isEmpty()) {
            throw new NoSuchElementException("Feed Time or Feed Schedule not found");
        }
        FeedTime feedTime = feedTimeRepository.findById(feedTimeId).get();
        FeedSchedule feedSchedule = feedScheduleRepository.findById(feedScheduleId).get();
        feedTime.assignFeedSchedule(feedSchedule);
        return feedTimeRepository.save(feedTime);
    }
}
