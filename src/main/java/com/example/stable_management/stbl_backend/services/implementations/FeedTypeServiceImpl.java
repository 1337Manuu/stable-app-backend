package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.dtos.FeedTypeDto;
import com.example.stable_management.stbl_backend.entities.FeedType;
import com.example.stable_management.stbl_backend.repositories.FeedTypeRepository;
import com.example.stable_management.stbl_backend.services.interfaces.FeedTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public FeedType createFeedType(FeedTypeDto feedTypeDto) {
        FeedType feedType = new FeedType();
        feedType.setName(feedTypeDto.name());
        return feedTypeRepository.save(feedType);
    }

    @Override
    public void deleteFeedTypeById(Long id) {
        feedTypeRepository.deleteById(id);
    }

    @Override
    public Optional<FeedType> getFeedTypeByName(String name) {
        return feedTypeRepository.findByName(name);
    }


}
