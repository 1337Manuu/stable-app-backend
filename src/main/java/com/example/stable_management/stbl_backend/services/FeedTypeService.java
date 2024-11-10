package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.dtos.feed_type_dto.FeedTypeDto;
import com.example.stable_management.stbl_backend.entities.FeedType;
import com.example.stable_management.stbl_backend.repositories.FeedTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedTypeService {

    private final FeedTypeRepository feedTypeRepository;

    public FeedTypeService(FeedTypeRepository feedTypeRepository) {
        this.feedTypeRepository = feedTypeRepository;
    }

    public List<FeedTypeDto> getAllFeedTypes() {
        return feedTypeRepository.findAll().stream()
                .map(FeedTypeDto::getDto)
                .collect(Collectors.toList());
    }

    public FeedTypeDto getFeedTypeById(Long id) {
        return FeedTypeDto.getDto(feedTypeRepository.findById(id).orElse(null));
    }

    public FeedTypeDto createFeedType(FeedTypeDto feedTypeDto) {
        FeedType createdFeedType = new FeedType();
        createdFeedType.setName(feedTypeDto.name());
        feedTypeRepository.save(createdFeedType);
        return FeedTypeDto.getDto(createdFeedType);
    }
}
