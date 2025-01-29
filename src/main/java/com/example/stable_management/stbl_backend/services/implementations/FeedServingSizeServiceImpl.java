package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.repositories.FeedServingSizeRepository;
import com.example.stable_management.stbl_backend.services.interfaces.FeedServingSizeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedServingSizeServiceImpl implements FeedServingSizeService {

    private final FeedServingSizeRepository feedServingSizeRepository;

    public FeedServingSizeServiceImpl(FeedServingSizeRepository feedServingSizeRepository) {
        this.feedServingSizeRepository = feedServingSizeRepository;
    }

    @Override
    public List<FeedServingSize> getAllFeedServingSizes() {
        return feedServingSizeRepository.findAll();
    }

    @Override
    public FeedServingSize getFeedServingSizeById(Long id) {
        return feedServingSizeRepository.findById(id).orElse(null);
    }

    @Override
    public FeedServingSize createFeedServingSize(FeedServingSize feedServingSize) {
        return feedServingSizeRepository.save(feedServingSize);
    }
}
