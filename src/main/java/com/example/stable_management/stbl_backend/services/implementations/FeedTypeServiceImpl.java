package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.entities.FeedType;
import com.example.stable_management.stbl_backend.repositories.FeedTypeRepository;
import com.example.stable_management.stbl_backend.services.interfaces.FeedTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedTypeServiceImpl implements FeedTypeService {

    private final FeedTypeRepository feedTypeRepository;

    public FeedTypeServiceImpl(FeedTypeRepository feedTypeRepository) {
        this.feedTypeRepository = feedTypeRepository;
    }

    @Override
    public List<FeedType> getAllFeedTypes() {
        return feedTypeRepository.findAll();
    }

    @Override
    public FeedType getFeedTypeById(Long id) {
        return feedTypeRepository.findById(id).orElse(null);
    }

    @Override
    public FeedType createFeedType(FeedType feedType) {
        return feedTypeRepository.save(feedType);
    }
}
