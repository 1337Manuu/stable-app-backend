package com.example.stable_management.stbl_backend.services;

import com.example.stable_management.stbl_backend.entities.FeedType;
import com.example.stable_management.stbl_backend.repositories.FeedTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedTypeService {

    private final FeedTypeRepository feedTypeRepository;

    public FeedTypeService(FeedTypeRepository feedTypeRepository) {
        this.feedTypeRepository = feedTypeRepository;
    }

    public List<FeedType> getAllFeedTypes() {
        return feedTypeRepository.findAll();
    }

    public FeedType getFeedTypeById(Long id) {
        return feedTypeRepository.findById(id).orElse(null);
    }

    public FeedType createFeedType(FeedType feedType) {
        return feedTypeRepository.save(feedType);
    }
}
