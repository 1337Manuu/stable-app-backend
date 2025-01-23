package com.example.stable_management.stbl_backend.services;

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

    public List<FeedServingSize> getAllFeedServingSizes() {
        return feedServingSizeRepository.findAll();
    }

    public FeedServingSize getFeedServingSizeById(Long id) {
        return feedServingSizeRepository.findById(id).orElse(null);
    }

    public FeedServingSize createFeedServingSize(FeedServingSize feedServingSize) {
        return feedServingSizeRepository.save(feedServingSize);
    }
}
