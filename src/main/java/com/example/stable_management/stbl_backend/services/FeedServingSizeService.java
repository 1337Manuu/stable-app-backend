package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.feed_schedule_dto.FeedScheduleDto;
import com.example.stable_management.stbl_backend.dtos.feed_serving_size_dto.FeedServingSizeDto;
import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.repositories.FeedServingSizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedServingSizeService {

    private final FeedServingSizeRepository feedServingSizeRepository;

    public FeedServingSizeService(FeedServingSizeRepository feedServingSizeRepository) {
        this.feedServingSizeRepository = feedServingSizeRepository;
    }

    public List<FeedServingSizeDto> getAllFeedServingSizes() {
        return feedServingSizeRepository.findAll().stream()
                .map(FeedServingSizeDto::getDto)
                .collect(Collectors.toList());
    }

    public FeedServingSizeDto getFeedServingSizeById(Long id) {
        return FeedServingSizeDto.getDto(feedServingSizeRepository.findById(id).orElse(null));
    }

    public FeedServingSizeDto createFeedServingSize(FeedServingSizeDto feedServingSizeDto) {
        FeedServingSize feedServingSize = new FeedServingSize();
        feedServingSize.setName(feedServingSizeDto.name());
        feedServingSizeRepository.save(feedServingSize);
        return FeedServingSizeDto.getDto(feedServingSize);
    }
}
