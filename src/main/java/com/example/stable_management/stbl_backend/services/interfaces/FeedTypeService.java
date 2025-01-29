package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.entities.FeedType;

import java.util.List;

public interface FeedTypeService {
    List<FeedType> getAllFeedTypes();

    FeedType getFeedTypeById(Long id);

    FeedType createFeedType(FeedType feedType);
}
