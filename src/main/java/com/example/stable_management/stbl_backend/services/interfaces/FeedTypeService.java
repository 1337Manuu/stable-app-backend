package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.dtos.FeedTypeDto;
import com.example.stable_management.stbl_backend.entities.FeedType;

import java.util.List;
import java.util.Optional;

public interface FeedTypeService {
    List<FeedType> getAllFeedTypes();

    FeedType getFeedTypeById(Long id);

    FeedType createFeedType(FeedTypeDto feedTypeDto);

    void deleteFeedTypeById(Long id);

    Optional<FeedType> getFeedTypeByName(String name);
}
