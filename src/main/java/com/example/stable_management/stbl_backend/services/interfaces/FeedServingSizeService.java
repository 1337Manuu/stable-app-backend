package com.example.stable_management.stbl_backend.services.interfaces;

import com.example.stable_management.stbl_backend.dtos.FeedServingSizeDto;
import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;

import java.util.List;
import java.util.Optional;

public interface FeedServingSizeService {
    List<FeedServingSize> getAllFeedServingSizes();

    FeedServingSize getFeedServingSizeById(Long id);

    FeedServingSize createFeedServingSize(FeedServingSizeDto feedServingSizeDto);

    Optional<FeedServingSize> getFeedServingSizeByName(String name);
}
