package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.feed_time_dto.FeedTimeDto;
import com.example.stable_management.stbl_backend.entities.FeedTime;
import com.example.stable_management.stbl_backend.repositories.FeedTimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedTimeService {

    private final FeedTimeRepository feedTimeRepository;

    public FeedTimeService(FeedTimeRepository feedTimeRepository) {
        this.feedTimeRepository = feedTimeRepository;
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
        return FeedTimeDto.getDto(feedTime);
    }
}
