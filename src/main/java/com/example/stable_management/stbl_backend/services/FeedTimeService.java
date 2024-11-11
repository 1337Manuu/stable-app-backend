package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.feed_time_dto.FeedTimeDto;
import com.example.stable_management.stbl_backend.entities.FeedSchedule;
import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.entities.FeedTime;
import com.example.stable_management.stbl_backend.entities.FeedType;
import com.example.stable_management.stbl_backend.repositories.FeedScheduleRepository;
import com.example.stable_management.stbl_backend.repositories.FeedServingSizeRepository;
import com.example.stable_management.stbl_backend.repositories.FeedTimeRepository;
import com.example.stable_management.stbl_backend.repositories.FeedTypeRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class FeedTimeService {

    private final FeedTimeRepository feedTimeRepository;
    private final FeedServingSizeRepository feedServingSizeRepository;
    private final FeedTypeRepository feedTypeRepository;
    private final FeedScheduleRepository feedScheduleRepository;

    public FeedTimeService(FeedTimeRepository feedTimeRepository, FeedServingSizeRepository feedServingSizeRepository, FeedTypeRepository feedTypeRepository, FeedScheduleRepository feedScheduleRepository) {
        this.feedTimeRepository = feedTimeRepository;
        this.feedServingSizeRepository = feedServingSizeRepository;
        this.feedTypeRepository = feedTypeRepository;
        this.feedScheduleRepository = feedScheduleRepository;
    }

    public List<FeedTimeDto> getAllFeedTimes() {
        return feedTimeRepository.findAll().stream()
                .map(FeedTimeDto::getDto)
                .collect(Collectors.toList());
    }

    public FeedTimeDto getFeedTimeById(Long id) {
        return feedTimeRepository.findById(id)
                .map(FeedTimeDto::getDto)
                .orElse(null);
    }

    public  FeedTimeDto createFeedTime(FeedTimeDto feedTimeDto) {
        FeedTime feedTime = new FeedTime();
        feedTime.setTimeExpression(feedTimeDto.timeExpression());
        feedTimeRepository.save(feedTime);
        return FeedTimeDto.getDto(feedTime);
    }

    public FeedTimeDto assignFeedServingSizeToFeedTime(Long feedTimeId, Long feedServingSizeId) {
        if (feedTimeRepository.findById(feedTimeId).isEmpty() || feedServingSizeRepository.findById(feedServingSizeId).isEmpty()) {
            throw new NoSuchElementException("Feed Time or Feed Serving Size not found");
        };
        FeedTime feedTime = feedTimeRepository.findById(feedTimeId).get();
        FeedServingSize feedServingSize = feedServingSizeRepository.findById(feedServingSizeId).get();
        feedTime.assignFeedServingSize(feedServingSize);
        feedTimeRepository.save(feedTime);
        return FeedTimeDto.getDto(feedTime);
    }

    public FeedTimeDto assignFeedTypeToFeedTime(Long feedTimeId, Long feedTypeId) {
        if (feedTimeRepository.findById(feedTimeId).isEmpty() || feedTypeRepository.findById(feedTypeId).isEmpty()) {
            throw new NoSuchElementException("Feed Time or Feed Type not found");
        }
        FeedTime feedTime = feedTimeRepository.findById(feedTimeId).get();
        FeedType feedType = feedTypeRepository.findById(feedTypeId).get();
        feedTime.assignFeedType(feedType);
        feedTimeRepository.save(feedTime);
        return FeedTimeDto.getDto(feedTime);
    }

    public FeedTimeDto assignFeedScheduleToFeedTime(Long feedTimeId, Long feedScheduleId) {
        if (feedTimeRepository.findById(feedTimeId).isEmpty() || feedScheduleRepository.findById(feedScheduleId).isEmpty()) {
            throw new NoSuchElementException("Feed Time or Feed Schedule not found");
        }
        FeedTime feedTime = feedTimeRepository.findById(feedTimeId).get();
        FeedSchedule feedSchedule = feedScheduleRepository.findById(feedScheduleId).get();
        feedTime.assignFeedSchedule(feedSchedule);
        feedTimeRepository.save(feedTime);
        return FeedTimeDto.getDto(feedTime);
    }
}
