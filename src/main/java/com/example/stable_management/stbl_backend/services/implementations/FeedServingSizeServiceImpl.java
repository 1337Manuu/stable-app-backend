package com.example.stable_management.stbl_backend.services.implementations;

import com.example.stable_management.stbl_backend.dtos.FeedServingSizeDto;
import com.example.stable_management.stbl_backend.entities.FeedServingSize;
import com.example.stable_management.stbl_backend.repositories.FeedServingSizeRepository;
import com.example.stable_management.stbl_backend.services.interfaces.FeedServingSizeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public FeedServingSize createFeedServingSize(FeedServingSizeDto feedServingSizeDto) {
        FeedServingSize feedServingSize = new FeedServingSize();
        feedServingSize.setName(feedServingSizeDto.name());
        return feedServingSizeRepository.save(feedServingSize);
    }

    @Override
    public Optional<FeedServingSize> getFeedServingSizeByName(String name) {
        return feedServingSizeRepository.findByName(name);
    }


}
