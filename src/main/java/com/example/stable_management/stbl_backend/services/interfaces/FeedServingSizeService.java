package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.entities.FeedServingSize;

import java.util.List;

public interface FeedServingSizeService {
    List<FeedServingSize> getAllFeedServingSizes();

    FeedServingSize getFeedServingSizeById(Long id);

    FeedServingSize createFeedServingSize(FeedServingSize feedServingSize);
}
